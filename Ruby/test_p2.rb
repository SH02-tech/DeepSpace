#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Test program of the methods of the second practice.               | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative 'Hangar.rb'
    require_relative 'Damage.rb'
    require_relative 'EnemyStarShip.rb'
    require_relative 'GameUniverse.rb'

    class TestP2

        def initialize
        end

        def self.main

            # Construccion de objetos necesarios para el test

            s1 = ShieldBooster.new("Potenciador1", 9, 5)
            s2 = ShieldBooster.new("Potenciador2", 10.5, 4)
            s3 = ShieldBooster.new("Potenciador3", 7, 9)
            w1 = Weapon.new("arma1", WeaponType::LASER, 5)
            w2 = Weapon.new("arma2", WeaponType::MISSILE, 6)
            w3 = Weapon.new("arma3", WeaponType::PLASMA, 7)
            t1 = WeaponType::LASER
            t2 = WeaponType::MISSILE
            t3 = WeaponType::PLASMA
            l1 = Loot.new(10,5,4,5,6)
            l2 = Loot.new(4,5,6,7,8)
            escudos = [s1, s2, s3]
            armas = [w1, w2, w3, w3]
            tipoArmas = [t1,t2,t3]

            puts
            puts "------------------------------------"
            puts "------Probando la clase Hangar------"
            puts "------------------------------------"
            puts

            puts "Construyendo Hangar 1 con el constructor con un solo parámetro (capacidad)..."
            h1 = Hangar.newHangar(10)
            puts "Hangar 1..."
            puts h1.to_s
            puts "Inspect: " + h1.inspect
            puts
            puts "Añadiendo 2 escudos y 1 armas..."
            h1.addShieldBooster(s1)
            h1.addShieldBooster(s2)
            h1.addWeapon(w1)
            puts "Hangar 1..."
            puts h1.to_s
            puts "Inspect: " + h1.inspect
            puts
            puts "Quitando un escudo y un arma..."
            h1.removeShieldBooster(1)
            h1.removeWeapon(0)
            puts h1.to_s
            puts
            puts "Creando hangar 2, copia de hangar 1..."
            h2 = Hangar.newCopy(h1)
            puts "Hangar 2..."
            puts h2.to_s
            puts
            puts "Construyendo un hangar 3 con capacidad 1..."
            h3 = Hangar.newHangar(1)
            puts "Hangar 3..."
            puts h3.to_s
            puts "Añadiendo un arma a hangar 3..."
            h3.addWeapon(w1)
            puts "Hangar 3..."
            puts h3.to_s
            puts
            puts "Usando el arma copiado (no debería afectar a hangar 3)..."
            w1.useIt
            puts "Hangar 3..."
            puts h3.to_s
            puts
            puts "Probando el metodo removeShieldBooster sobre hangar 3 (no tendria que tener efecto alguno)..."
            h3.removeShieldBooster(4)
            puts "Hangar 3..."
            puts h3.to_s
            puts
            puts "Probando el metodo addShieldBooster sobre hangar 3(como no hay espacio debe devolver false)..."
            puts h3.addShieldBooster(s1)
            puts 

            puts
            puts "------------------------------------"
            puts "------Probando la clase Damage------"
            puts "------------------------------------"
            puts

            puts "Creando Damage 0 con newNumericWeapons(0 armas, 0 escudos)..."
            d0 = Damage.newNumericWeapons(0, 0)
            puts "Damage 0..."
            puts d0.to_s
            puts d0.inspect
            puts 
            puts "Creando Damage 1 con newNumericWeapons(5 armas, 6 escudos)..."
            d1 = Damage.newNumericWeapons(5, 6)
            puts "Damage 1..."
            puts d1.to_s
            puts d1.inspect
            puts 
            puts "Creando Damage 2 con new SpecificWeapons(armas,4 escudos)..."
            d2 = Damage.newSpecificWeapons(tipoArmas, 4)
            puts "Damage 2..."
            puts d2.to_s
            puts d2.inspect
            puts
            puts "Creando Damage 3 copia de Damage 1..."
            d3 = Damage.newCopy(d1)
            puts "Damage 3..."
            puts d3.to_s
            puts d3.inspect
            puts 
            puts "Creando Damage 4 copia de Damage 2..."
            d4 = Damage.newCopy(d2)
            puts "Damage 4..."
            puts d4.to_s
            puts d4.inspect
            puts
            puts "Probando metodo adjust en Damage 1 (creando Ajustado 1 version numerica)..."
            adjust1 = d1.adjust(armas,escudos)
            puts "Ajuste 1..."
            puts adjust1.to_s
            puts adjust1.inspect
            puts
            puts "Probando metodo adjust en Damage 2 (Creando Ajustado 2 version vector)"
            adjust2 = d2.adjust(armas,escudos)
            puts "Ajuste 2..."
            puts adjust2.to_s
            puts adjust2.inspect
            puts
            puts "Probando discard Weapon en Damage 3 (caso numerico)..."
            d3.discardWeapon(t2)
            puts "Damage 3..."
            puts d3.to_s
            puts d3.inspect
            puts
            puts "Probando discard Weapon en Damage 4 (caso vector)..."
            puts "Damage 4(Before)..."
            puts d4.to_s
            puts d4.inspect
            puts
            d4.discardWeapon(w2)
            puts "Damage 4..."
            puts d4.to_s
            puts d4.inspect
            puts
            puts "Probando discardShieldBooster en Damage 1..."
            d1.discardShieldBooster
            puts "Damage 1..."
            puts d1.to_s
            puts d1.inspect
            puts
            puts "Probando discardShieldBooster en Damage 4..."
            d4.discardShieldBooster
            puts "Damage 4..."
            puts d4.to_s
            puts d4.inspect
            puts
            puts "Probando has no effect en Damage 0(Debe devolver true)..."
            puts d0.hasNoEffect
            puts "Probando has no effect en Damage 1(Debe devolver false)..."
            puts d1.hasNoEffect
            puts

            puts
            puts "------------------------------------"
            puts "--Probando la clase EnemyStarShip---"
            puts "------------------------------------"
            puts

            puts "Creando EnemyStarShip 1..."
            e1 = EnemyStarShip.new(10,45,60,l1,d1)
            puts "EnemyStarShip 1..."
            puts e1.to_s
            puts
            puts "Probando el metodo Shot..."
            puts e1.receiveShot(12)
            puts

            puts "Creando copia de EnemyStarShip 1..."
            e1copy = EnemyStarShip.newCopy(e1)
            puts "Copia EnemyStarShip 1..."
            puts e1copy.to_s
            puts

            d1.discardShieldBooster

            puts "Mostrando EnemyStarShip 1 tras modificar Damage... (debería quedar igual)"
            puts "EnemyStarShip 1..."
            puts e1.to_s
            puts
            puts "Probando el metodo Shot..."
            puts e1.receiveShot(12)
            puts

            puts "Mostrando copia de EnemyStarShip 1 tras modificar Damage... (debería quedar igual)"
            puts "Copia EnemyStarShip 1..."
            puts e1copy.to_s
            puts

            puts
            puts "------------------------------------"
            puts "---Probando la clase GameUniverse---"
            puts "------------------------------------"
            puts
            
            gu = GameUniverse.new

            puts gu.to_s
            puts gu.inspect
        end

    end # end of TestP2

    TestP2.main

end # end of Deepspace