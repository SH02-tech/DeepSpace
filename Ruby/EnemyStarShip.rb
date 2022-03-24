#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Description...                                                    | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative "Loot.rb"
    require_relative "Damage.rb"
    require_relative "ShotResult.rb"

    class EnemyStarShip
        
        def initialize(n, a, s, l, d)
            @name        = n
            @ammoPower   = a
            @shieldPower = s
            @loot        = l
            @damage      = d
        end

        def self.newCopy(e)
            new(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage)
        end

        def getUIversion
            EnemyToUI.new(self)
        end

        def fire 
            ammoPower
        end

        def protection
            shieldPower
        end

        attr_reader :ammoPower, :damage, :loot, :name, :shieldPower
       
        def receiveShot(shot)
            if shieldPower < shot
                return ShotResult::DONOTRESIST
            else
                return ShotResult::RESIST
            end
        end

        def to_s
            "ENEMY STARSHIP: \n" + \
            "Name: #{name}, Ammo power: #{ammoPower}, ShieldPower: #{shieldPower}\n" + \
            "#{loot}\n" + \
            "#{damage}"
        end

    end

=begin
    ### TEST PROGRAM

    l = Loot.new(10, 20 ,30, 40, 50)
    d = Damage.newNumericWeapons(80, 90)
    e = EnemyStarShip.new("naveEnemiga", 15, 20, l, d)
    puts e.to_s
    puts
    if e.receiveShot(21) == ShotResult::DONOTRESIST
        puts "No resiste"
    else
        puts "Resiste"
    end
    puts
    var = e.shieldPower
    puts "El shieldPower es: #{e.shieldPower}"
    var = 0
    puts "El nuevo shieldPower es: #{e.shieldPower}"
    puts
    fuego = e.fire
    puts "Valor de fire: #{e.fire}"
    fuego = -321
    puts "¿Se puede modificar fire desde fuera? #{e.fire}"
    puts
=end

end