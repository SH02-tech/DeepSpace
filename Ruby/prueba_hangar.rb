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

            s = [s1, s2, s3]
            w = [w1, w2, w3]
            h = Hangar.newHangar(102)

            puts
            puts h.to_s
            
        end
    end

    m = Main.main

end