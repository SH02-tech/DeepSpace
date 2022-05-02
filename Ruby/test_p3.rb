#encoding:utf-8

module Deepspace

    require_relative "GameUniverse.rb"

    class TestP3

        def initialize
        end

        def self.main 

            puts "==================================="
            puts "TEST PRACTICE 3"
            puts "==================================="

            puts "==================================="
            puts "TESTING GAME UNIVERSE"
            puts "==================================="
            
            # Ejecutamos init y a continuación discard* y mount* 
            # luego los metodos combat, nexTurn y have a winner

            univ = GameUniverse.new
            univ.init(["Mario", "Maria"])
            
            puts "----------> Game Universe:"
            puts univ.to_s
            puts "----------> Using mount methods:"
            univ.mountWeapon(0)
            univ.mountShieldBooster(0)
            puts "----------> Game Universe:"
            puts univ.to_s
            puts "----------> Using discardInHangar:"
            univ.discardShieldBoosterInHangar(0)
            univ.discardWeaponInHangar(0)
            puts "----------> Game Universe:"
            puts univ.to_s
            puts "----------> Combat: "
            puts "Result " + univ.combat.to_s
            puts "----------> Estado del juego: " + univ.state.to_s
            puts "----------> Using discard*:"
            univ.discardWeapon(0)
            univ.discardShieldBooster(0)
            univ.discardHangar
            puts "----------> Game Universe:"
            puts univ.to_s
            puts "----------> Next turn:"
            puts univ.nextTurn.to_s
            puts "----------> Testing if there is a winner:"
            puts univ.haveAWinner
            puts

        end

    end

    TestP3.main

end
