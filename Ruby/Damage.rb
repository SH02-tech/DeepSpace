#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Description...                                                    | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative "WeaponType.rb"
    require_relative "ShieldBooster.rb"

    class Damage

        @@NOTUSED = -1

        # Constructors

        def initialize(w, s, wl)
            @nWeapons = w
            @nShields = s
            @weapons  = wl
        end

        attr_reader :nShields, :nWeapons, :weapons

        def self.newNumericWeapons(w, s)
            new(w, s, nil)
        end

        def self.newSpecificWeapons(wl, s)
            new(@@NOTUSED, s, wl)
        end

        private_class_method :new

        def self.newCopy(d)
            if d.nWeapons == @@NOTUSED   # Usamos array
                newSpecificWeapons(d.weapons, d.nShields)
            else                  # Usamos array the weapons
                newNumericWeapons(d.nWeapons, d.nShields)
            end
        end

        def getUIversion()
            DamageToUI.new(self)
        end

        def arrayContainsType(w, t)
            index = -1
            count = 0
            found = false
            while count < w.length && !found
                if (w[count] == t)
                    index = count
                    found = true
                end
                count += 1
            end

            return index
        end

        private :arrayContainsType

        def adjust(w, s)

            if nWeapons == @@NOTUSED   # Caso vector
                
                weaponsCopy = weapons
                w.each do |element|
                    pos = arrayContainsType(weaponsCopy, element) 
                    if pos != -1
                        weaponsCopy.delete_at(pos)
                    end
                end

                nShieldsCopy = nShields - s.length
                if nShieldsCopy < 0
                    nShieldsCopy = 0
                end
                
                Damage.newSpecificWeapons(weaponsCopy, nShieldsCopy)

            else    # Caso númerico
                nWeaponsCopy = nWeapons - w.length
                if nWeaponsCopy < 0
                    nWeaponsCopy = 0
                end

                nShieldsCopy = nShields - s.length
                if nShieldsCopy < 0
                    nShieldsCopy = 0
                end

                Damage.newNumericWeapons(nWeaponsCopy, nShieldsCopy)
            end
        end

        def discardWeapon(w)    # w : weaponn
            if @nWeapons == @@NOTUSED && @weapons.length > 0 # Caso vector
                @weapons.delete(w.type)
            elsif @nWeapons > 0                       # Caso numérico
                @nWeapons -= 1
            end
            return nil
        end
        
        def discardShieldBooster()
            if @nShields > 0
                @nShields -=1
            end
            return nil
        end

        def hasNoEffect
            if nWeapons == @@NOTUSED       # Caso vector
                nShields == 0 && weapons.length == 0
            else                    # Caso numérico
                nShields == 0 && nWeapons == 0
            end
        end

        def to_s

            if nWeapons == @@NOTUSED

                weaponsString = ""
                @weapons.each do |w|
                    case w
                    when WeaponType::LASER
                        weaponsString += "LASER, "
                    when WeaponType::MISSILE
                        weaponsString += "MISSILE, "
                    when WeaponType::PLASMA
                        weaponsString += "PLASMA, "
                    end
                end

                "DAMAGE: \n" + \
                "Number of shields: #{nShields} \n" + \
                "List of weapons: \n" + \
                "#{weaponsString}"
            else
                "DAMAGE: \n" + \
                "Number of weapons: #{nWeapons} \n" + \
                "Number of shields: #{nShields} \n"
            end
        end

    end

    ### TEST PROGRAM



    # Declarations

    a = [WeaponType::LASER, WeaponType::LASER, WeaponType::MISSILE, WeaponType::PLASMA, WeaponType::LASER]
    s1 = ShieldBooster.new("Escudo1", 14, -1)
    s2 = ShieldBooster.new("Escudo2", 10, -20)
    s3 = ShieldBooster.new("Escudo3", 1, 0)
    b = [s1, s2, s3]
    d1 = Damage.newNumericWeapons(10, 20)
    d2 = Damage.newSpecificWeapons(a, 38)

    # Operations

    puts "Firts damage type: "
    puts d1.to_s
    puts
    puts "Second damage type: "
    puts d2.to_s
    puts
    w = [WeaponType::LASER, WeaponType::MISSILE, WeaponType::PLASMA, WeaponType::LASER, WeaponType::MISSILE, WeaponType::MISSILE]
    d3 = d2.adjust(w, b)
    puts d3.to_s
    puts

    # Probaremos el discard, el constructor de copia y el metodo hasNoEffect

    puts "Descartando dos escudos de d1"
    d1.discardShieldBooster
    d1.discardShieldBooster
    puts d1
    puts
    puts "Descartando dos armas del damage dos: " 
    puts d2.discardWeapon(w[0]) # Como solo queda un laser y lo quitamos pues deberia de dejar de haber 
    puts d2.discardWeapon(w[2])
    puts d2
    puts
    puts "Probando has no effect sobre d1: "
    if d1.hasNoEffect()
        puts "has no effect sobre d1 igual a true."
    else
        puts "has no effect en el d1 igual a falso. "
    end
    d3 = Damage.newNumericWeapons(0,0)
    puts "Probando has no effect sobre un objeto damage con 0 nWeapons y 0 nShields"
    if d3.hasNoEffect()
        puts "has no effect sobre d3 igual a true."
    else
        puts "has no effect en el d3 igual a falso. "
    end
    d4 = Damage.newSpecificWeapons([],0)
    puts "Probando has no effect con un objeto con 0 shields y [] weaponsTypes. "
    if d4.hasNoEffect()
        puts "has no effect sobre d4 igual a true."
    else
        puts "has no effect en el d4 igual a falso. "
    end
    puts "Probando el constructor de copia: "
    d5=Damage.newCopy(d4)
    puts "Este es el objeto copia:"
    puts d5.to_s

end
