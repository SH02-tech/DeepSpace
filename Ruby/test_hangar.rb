module Deepspace
    
    require_relative 'Hangar.rb'

    class Main

        def initialize
        end

        def self.main 
            
            s1 = ShieldBooster.new("Potenciador1", 9, 5)
            s2 = ShieldBooster.new("Potenciador2", 10.5, 4)
            s3 = ShieldBooster.new("Potenciador3", 7, 9)
            w1 = Weapon.new("arma1", WeaponType::LASER, 5)
            w2 = Weapon.new("arma2", WeaponType::MISSILE, 6)
            w3 = Weapon.new("arma3", WeaponType::PLASMA, 7)
            w0 = Weapon.new("arma0", WeaponType::LASER, 5)

            s = [s1, s2, s3]
            w = [w1, w2, w3]
            h = Hangar.new(102)

            puts
            puts h.to_s

            # Testing get methods to avoid changes in the instance

            h.addShieldBooster(s1)
            h.addShieldBooster(s2)
            h.addShieldBooster(s3)
            h.addWeapon(w1)
            h.addWeapon(w2)
            h.addWeapon(w3)

            puts 
            puts h.to_s

            armas = h.weapons
            escudos = h.shieldBoosters

            puts "Armas: "
            puts armas.to_s
            puts "Escudos"
            puts escudos.to_s

            armas[0] = w0
            escudos.clear

            puts
            puts "¿ Algun cambio en el objeto despues de borrar las armas ?"
            puts h.to_s
            puts
            
            max=h.maxElements
            max = -10000000

            puts "¿Ha cambiado el objeto despues de modificar maxElements?"
            puts h.to_s
            puts

            
        end
    end

    m = Main.main

end