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

    end # end of class EnemyStarShip

end # Deepspace