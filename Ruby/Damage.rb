#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Description...                                                    | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative "Weapon.rb"

    class Damage

        # Constructors

        def initialize(w, s, wl)
            @nWeapons = w
            @nShields = s
            @weapons  = wl
        end

        def self.newNumericWeapons(w, s)
            new(w, s, [])
        end

        def self.newSpecificWeapons(wl, s)
            new(wl.length, s, wl)
        end

        def self.newCopy(d)
            new(d.nWeapons, d.nShields, d.weapons)
        end

        def getUIversion()
            DamageToUI.new(self)
        end

        def arrayContainsType(w, t)
            index = -1
            count = 0
            found = false
            while count < w.length && !found
                if (w[count].type == t)
                    index = count
                    found = true
                end
                count += 1
            end

            return index
        end

        def adjust(w, s)
            # Preguntar al profe
        end

        def discardWeapon(w)
            if weapons.length > 0
                @weapons.delete(w)
            elsif @nWeapons > 0
                @nWeapons -= 1
            end
            return nil
        end
        
        def discardShieldBooster()
            if nShields > 0
                @nShields -=1
            end
            return nil
        end

        def hasNoEffect
            nWeapons == 0 && nShields == 0
        end

        def to_s
            weaponsString = ""
            weapons.each do |w|
                weaponsString += "#{w.to_s}\n"
            end
            
            "DAMAGE: \n" + \
            "Number of shields: #{nShields} \n" + \
            "Number of weapons: #{nWeapons} \n" + \
            "#{weaponsString}"
        end

        attr_reader :nShields, :nWeapons, :weapons

        private_class_method :new
        private :arrayContainsType
    
    end

    ### TEST PROGRAM

=begin

    # Declarations

    d1 = Damage.newNumericWeapons(10, 20)
    w1 = Weapon.new("arma_1", WeaponType::LASER, 5)
    w2 = Weapon.new("arma_2", WeaponType::MISSILE, 5)
    w3 = Weapon.new("arma_2", WeaponType::PLASMA, 5)
    a =[w1,w2]
    d2 = Damage.newSpecificWeapons(a, 20)

    # Operations

    puts "Damage object 1: "
    puts d1.to_s + "\n"
    puts "LLamamos a discardShieldBooster(): "

    var = d1.discardShieldBooster()
    if var == nil
        puts "Devuelve nil"
    else
        puts var
    end

    puts
    puts "Damage object 1:"
    puts d1.to_s + "\n"
    puts "Llamamos a hasNoEffect"

    if d1.hasNoEffect()
        puts "No tiene efecto"
    else
        puts "Tiene efecto"
    end

    puts
    puts d2.to_s
    puts

    # puts
    # puts "Damage objetc 2: "
    # puts d2.to_s
    # puts
    # puts "Llamamos a arrayContainsType: "

    # index = d2.arrayContainsType(a,w1)
    # if index == -1
    #     puts "No coincide el tipo"
    # else
    #     puts "Coincide el tipo"
    # end

    # Vamos a probar a modificar el estado del objeto d2
    weapons_d2 = d2.weapons
    weapons_d2.delete_at(1)

    puts "Nuevo estado de weapon d2: \n"
    puts d2.to_s
    puts

    d2.discardWeapon(w1)

    puts
    puts "After discard a weapon"
    puts d2.to_s
    puts

    # parece que se modifica el estado del array a
    a.each do |indice|
        puts indice
    end

    # Probemos a modificar el array a para ver si se modifica
    # el objeto.
    a.push(w3)
    puts
    puts d2.to_s
    puts

=end

end
