#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | This class represents a SpaceStation in a war.                    | #
# +-------------------------------------------------------------------+ #


module Deepspace

    require_relative "Loot.rb"
    require_relative "Damage.rb"
    require_relative "Weapon.rb"
    require_relative "ShieldBooster.rb"
    require_relative "Hangar.rb"
    require_relative "SuppliesPackage.rb"
    require_relative "SpaceStationToUI.rb"

    class SpaceStation

        @@MAXFUEL = 100
        @@SHIELDLOSSPERUNITSHOT = 0.1

        # Parameters:
        # n. String that represents name.
        # supplies. SuppliesPackage with supplies given. 
        def initialize(n, supplies)
            @ammoPower = supplies.ammoPower
            @fuelUnits = supplies.fuelUnits
            @name = n
            @nMedals = 0
            @shieldPower = supplies.shieldPower
            @pendingDamage = nil
            @weapons = Array.new
            @shieldBoosters = Array.new
            @hangar = nil
        end

        attr_reader :ammoPower, :fuelUnits, :hangar, :name, :nMedals, :pendingDamage, :shieldPower, :shieldBoosters, :weapons

        def speed # TODO: This name?
            @fuelUnits / @@MAXFUEL.to_f
        end

        def getUIversion
            SpaceStationToUI.new(self)
        end

        def assignFuelValue(f)
            @fuelUnits = [f, @@MAXFUEL].min
        end

        private :assignFuelValue

        def cleanPendingDamage
            if (@pendingDamage.hasNoEffect)
                @pendingDamage = nil
            end
        end

        private :pendingDamage

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
        end

        def discardHangar
            @hangar = nil
        end

        def discardShieldBooster(i)
            # TODO in P3
        end

        def discardShieldBoosterInHangar(i)
            if (@hangar != nil)
                @hangar.removeShieldBooster(i)
            end
        end

        def discardWeapon(i)
            # TODO in P3
        end

        def discardWeaponInHangar(i)
            if (@hangar != nil)
                @hangar.removeWeapon(i)
            end
        end

        def fire
            # TODO in P3
        end       

        def mountShieldBooster(i)
            candidate = @hangar.removeShieldBooster(i)

            if (candidate != nil)
                @shieldBoosters.push(candidate)
            end
        end

        def mountWeapon(i)
            candidate_weapon = @hangar.removeWeapon(i)

            if (candidate_weapon != nil)
                @weapons.push(candidate_weapon)
            end
        end

        def move
            @fuelUnits = (1 - self.speed) * @fuelUnits # Non-negative
        end

        def protection
            # TODO in P3
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
            # TODO in P3
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
            # TODO in P3
        end

        def setPendingDamage(d) # TODO: Name?
            @pendingDamage = d.adjust(@weapons, @shieldBoosters)
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
    h = Deepspace::Hangar.newHangar(3)
    h.addShieldBooster(s1)
    h.addShieldBooster(s2)
    h.addWeapon(w1)
    
    # Caso de prueba

    puts "###############################"
    puts "Inicio"
    puts "###############################"

    space_station = Deepspace::SpaceStation.new("Casanova", supplies_package)
    space_station.receiveHangar(h)
    puts space_station.to_s

    puts "ammoPower: " + space_station.ammoPower.to_s

    puts "###############################"
    puts "Modificación"
    puts "###############################"

    space_station.mountShieldBooster(0)
    space_station.mountShieldBooster(0)
    space_station.mountWeapon(0)
    space_station.mountWeapon(2) # No existe. 

    puts "Mounted values: " + space_station.to_s
    puts "Weapons: " + space_station.weapons.to_s
    puts "ShieldBoosters: " + space_station.shieldBoosters.to_s

    puts "###############################"
    puts "Modificación de move y modificación de Hangar"
    puts "###############################"

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

    puts "###############################"
    puts "Adición de elementos al Hangar"
    puts "###############################"

    space_station.receiveShieldBooster(s1)
    space_station.receiveWeapon(w1)
    space_station.receiveSupplies(supplies_package)

    puts space_station.to_s

    puts "###############################"
    puts "Eliminación de elementos al Hangar"
    puts "###############################"

    space_station.discardShieldBooster(1)
    space_station.discardHangar

    puts space_station.to_s

    puts "###############################"
    puts "Damage implementado"
    puts "###############################"
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