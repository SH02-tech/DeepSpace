#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# |                                                                   | #
# +-------------------------------------------------------------------+ #

module Deepspace

require_relative "GameCharacter.rb"

class Dice
    
    # Constructor
    def initialize
        @NHANGARSPROB  = 0.25
        @NSHIELDSPROB  = 0.25
        @NWEAPONSPROB  = 0.33
        @FIRSTSHOTPROB = 0.5
        @generator     = Random.new
    end

    # Determines the number of hangars that will receive a space stantion
    def initWithNHangars
        if @generator.rand < @NHANGARSPROB
            return 0
        else
            return 1
        end
    end

    # Determines the number of weapons that will receive a space station
    def initWithNWeapons
        prob = @generator.rand
        if prob < @NWEAPONSPROB
            return 1
        elsif @NWEAPONSPROB < prob && prob < (2*@NWEAPONSPROB)  
            return 2
        else
            return 3
        end
    end

    # Determines the shields that will receive a space station
    def initWithNShields
        if @generator.rand < @NSHIELDSPROB
            return 0
        else
            return 1
        end
    end

    # Determines the number of the player who starts the game
    def whoStarts(nPlayers)
        @generator.rand(nPlayers)
    end

    # Determines the character who will shot first
    def firstShot
        if @generator.rand < @FIRSTSHOTPROB
            return GameCharacter::SPACESTATION
        else
            return GameCharacter::ENEMYSTARSHIP
        end
    end 

    # Determines if the space sattion will move to avoid a shot
    def spaceStationMoves(speed)
        if @generator.rand < speed
            return true
        else
            return false
        end
    end

end


### TEST PROGRAM    

# d = Dice.new
# puts d.initWithNHangars
# puts d.initWithNHangars
# puts d.initWithNShields
# puts d.whoStarts(10)
# puts d.firstShot
# puts d.spaceStationMoves(9)