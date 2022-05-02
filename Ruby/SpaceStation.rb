#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | This class represents a SpaceStation in a war.                    | #
# +-------------------------------------------------------------------+ #


module Deepspace

    require_relative "CardDealer.rb"
    require_relative "Loot.rb"
    require_relative "Damage.rb"
    require_relative "Weapon.rb"
    require_relative "ShieldBooster.rb"
    require_relative "Hangar.rb"
    require_relative "ShotResult.rb"
    require_relative "SuppliesPackage.rb"
    require_relative "SpaceStationToUI.rb"

    class SpaceStation

        @@MAXFUEL = 100
        @@SHIELDLOSSPERUNITSHOT = 0.1

        # Parameters:
        # n. String that represents name.
        # supplies. SuppliesPackage with supplies given. 
        def initialize(n, supplies)
            @ammoPower      = supplies.ammoPower
            @fuelUnits      = supplies.fuelUnits
            @name           = n # TODO: Se modifica?
            @nMedals        = 0
            @shieldPower    = supplies.shieldPower
            @pendingDamage  = nil
            @weapons        = Array.new
            @shieldBoosters = Array.new
            @hangar         = nil
        end

        attr_reader :ammoPower, :fuelUnits, :hangar, :name, :nMedals, :pendingDamage, :shieldPower, :shieldBoosters, :weapons

        def getSpeed
            @fuelUnits / @@MAXFUEL.to_f
        end

        def getUIversion
            SpaceStationToUI.new(self)
        end

        def assignFuelValue(f)
            @fuelUnits = [f, @@MAXFUEL].min
            return nil
        end

        private :assignFuelValue

        def cleanPendingDamage
            if (@pendingDamage.hasNoEffect)
                @pendingDamage = nil
            end
            return nil
        end

        def cleanUpMountedItems
            pos = 0
            while pos < @weapons.length do
                if @weapons[pos].uses == 0
                    @weapons.delete_at(pos)
                else
                    pos += 1
                end
            end

            pos = 0
            while pos < @shieldBoosters.length do
                if @shieldBoosters[pos].uses == 0
                    @shieldBoosters.delete_at(pos)
                else
                    pos += 1
                end
            end
            return nil
        end

        def discardHangar
            @hangar = nil
            return nil
        end

        def discardShieldBooster(i)
            size = @shieldBoosters.length

            if (0<=i && i<size)
                s = @shieldBoosters.delete_at(i)

                if (@pendingDamage != nil)
                    @pendingDamage.discardShieldBooster
                    cleanPendingDamage
                end
            end

            return nil
        end

        def discardShieldBoosterInHangar(i)
            if (@hangar != nil)
                @hangar.removeShieldBooster(i)
            end
            return nil
        end

        def discardWeapon(i)
            size = @weapons.length

            if (0<= i && i < size)
                w = @weapons.delete_at(i)

                if (@pendingDamage != nil)
                    @pendingDamage.discardWeapon(w)
                    cleanPendingDamage
                end
            end

            return nil
        end

        def discardWeaponInHangar(i)
            if (@hangar != nil)
                @hangar.removeWeapon(i)
            end
            return nil
        end

        def fire
            factor=1.0

            @weapons.each do |w|
                factor *= w.useIt
            end

            @ammoPower*factor
        end       

        def mountShieldBooster(i)
            if (@hangar != nil)
                candidate = @hangar.removeShieldBooster(i)

                if (candidate != nil)
                    @shieldBoosters.push(candidate)
                end
            end
            return nil
        end

        def mountWeapon(i)
            if (@hangar != nil)
                candidate_weapon = @hangar.removeWeapon(i)

                if (candidate_weapon != nil)
                    @weapons.push(candidate_weapon)
                end
            end
            return nil
        end

        def move
            @fuelUnits = (1 - self.getSpeed) * @fuelUnits # Non-negative always
        end

        def protection
            factor=1.0

            @shieldBoosters.each do |s|
                factor *= s.useIt
            end

            @shieldPower*factor
        end

        def receiveHangar(h)
            if (@hangar == nil)
                @hangar = Hangar.newCopy(h)
            end
        end

        def receiveShieldBooster(s)
            if (@hangar != nil)
                @hangar.addShieldBooster(s)
            else
                false
            end
        end

        def receiveShot(shot)
            myProtection = protection

            if (myProtection >= shot)
                @shieldPower -= @@SHIELDLOSSPERUNITSHOT*shot
                if (@shieldPower < 0)
                    @shieldPower = 0
                end
                return ShotResult::RESIST
            else
                @shieldPower = 0
                return ShotResult::DONOTRESIST
            end
        end

        def receiveSupplies(s)
            @ammoPower += s.ammoPower
            @fuelUnits += s.fuelUnits
            @shieldPower += s.shieldPower
        end

        def receiveWeapon(w)
            if (@hangar != nil)
                @hangar.addWeapon(w)
            else
                false
            end
        end

        def setLoot(loot)
            dealer = CardDealer.instance
            h = loot.nHangars

            if (h>0)
                hangar = dealer.nextHangar
                receiveHangar(hangar)
            end

            elements = loot.nSupplies

            for i in (1..elements)
                sup = dealer.nextSuppliesPackage
                receiveSupplies(sup)
            end

            elements = loot.nWeapons

            for i in (1..elements)
                weap = dealer.nextWeapon
                receiveWeapon(weap)
            end

            elements = loot.nShields

            for i in (1..elements)
                sh = dealer.nextShieldBooster
                receiveShieldBooster(sh)
            end

            medals = loot.nMedals

            @nMedals += medals

            return nil
        end

        def setPendingDamage(d)
            if (d != nil)
                @pendingDamage = d.adjust(@weapons, @shieldBoosters)
            end
            return nil
        end

        def validState
            state = true

            if (@pendingDamage != nil)
                if (!@pendingDamage.hasNoEffect)
                    state = false
                end
            end
            
            return state
        end 

        def to_s
            s = "["
            s += "ammoPower: " + @ammoPower.to_s + ", fuelUnits: " + @fuelUnits.to_s
            s += ", name: " + @name + ", nMedals: " + @nMedals.to_s + ", shieldPower: " 
            s += @shieldPower.to_s + ", pendingDamage: " + @pendingDamage.to_s
            s += ", weapons: " + @weapons.to_s + ", shieldBoosters: " + @shieldBoosters.to_s
            s += ", hangar: " + @hangar.to_s
            s += "]"

            return s
        end

    end # SpaceStation

end # Deepspace

# TEST
if $0 == __FILE__ then

    # Inicialización de valores. 
    supplies_package = Deepspace::SuppliesPackage.new(3,4,5)
    s1 = Deepspace::ShieldBooster.new("Potenciador1", 10.5, 5)
    s2 = Deepspace::ShieldBooster.new("Potenciador2", 10.5, 5)
    w1 = Deepspace::Weapon.new("arma1", Deepspace::WeaponType::LASER, 5)
    h = Deepspace::Hangar.new(5)
    h.addShieldBooster(s1)
    h.addShieldBooster(s2)
    h.addWeapon(w1)

    l = Deepspace::Loot.new(2,2,2,2,2)
    
    # Caso de prueba

    puts 
    puts "###############################"
    puts "Inicio"
    puts "###############################"
    puts

    name = "Casanova"
    space_station = Deepspace::SpaceStation.new(name, supplies_package)
    space_station.receiveHangar(h)
    puts "SpaceStation state: " + space_station.to_s

    puts "ammoPower: " + space_station.ammoPower.to_s

    puts 
    puts "###############################"
    puts "Modificación"
    puts "###############################"
    puts 

    space_station.mountShieldBooster(0)
    space_station.mountShieldBooster(0)
    space_station.mountWeapon(0)
    space_station.mountWeapon(2) # No existe. 

    puts "SpaceStation with mounted values: " + space_station.to_s
    puts "Weapons: " + space_station.weapons.to_s
    puts "ShieldBoosters: " + space_station.shieldBoosters.to_s

    puts
    puts "###############################"
    puts "Modificación de move y modificación de Hangar"
    puts "###############################"
    puts

    space_station.move
    space_station.move
    space_station.move
    space_station.move
    space_station.move
    space_station.move
    space_station.move
    space_station.move

    puts "Moved: " + space_station.to_s

    space_station.receiveHangar(h) # Should not work

    puts "Space station: " + space_station.to_s

    puts
    puts "###############################"
    puts "Adición de elementos al Hangar"
    puts "###############################"
    puts

    space_station.receiveShieldBooster(s1)
    space_station.receiveWeapon(w1)
    space_station.receiveSupplies(supplies_package)

    puts space_station.to_s

    puts
    puts "###############################"
    puts "Fire y protection"
    puts "###############################"
    puts

    puts "Fire: " + space_station.fire.to_s
    puts "Protection: " + space_station.protection.to_s

    puts
    puts "###############################"
    puts "Recibimiento de disparo y Lote"
    puts "###############################"
    puts

    puts space_station.receiveShot(2)
    puts space_station.to_s

    # Declarado arriba: l = Deepspace::Loot.new(2,2,2,2,2)
    space_station.setLoot(l)
    puts space_station.to_s

    puts
    puts "###############################"
    puts "Eliminación de elementos"
    puts "###############################"
    puts

    space_station.discardShieldBooster(1)
    space_station.discardWeapon(1)
    puts space_station.to_s

    space_station.discardHangar
    puts space_station.to_s

    puts 
    puts "###############################"
    puts "Damage implementado"
    puts "###############################"
    puts 
    
    damage = Deepspace::Damage.newNumericWeapons(2,3)
    puts space_station.to_s

    if (space_station.validState)
        puts "Correct state"
    else
        puts "Incorrect state"
    end

    space_station.setPendingDamage(damage)
    puts space_station.to_s

    if (space_station.validState)
        puts "Correct state"
    else
        puts "Incorrect state"
    end
    
end