#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | This class performs all random values generated in the game.      | #
# +-------------------------------------------------------------------+ #

module Deepspace

require_relative "GameCharacter.rb"

class Dice
    
    # Constructor
    def initialize
        @NHANGARSPROB        = 0.25
        @NSHIELDSPROB        = 0.25
        @NWEAPONSPROB        = 0.33
        @FIRSTSHOTPROB       = 0.5
        @EXTRAEFFICIENCYPROB = 0.8
        @generator           = Random.new
    end

    # Determines if a space station fire with an extra BetaPower
    def extraEfficiency
        if @generator.rand < @EXTRAEFFICIENCYPROB
            true
        else
            false
        end
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
        return @generator.rand < speed
    end

    # to_s method
    def to_s
        return "Probabilities: " + \
            "\tHangars: #{@NHANGARSPROB}, " + \
            "\tShields: #{@NSHIELDSPROB}, " + \
            "\tWeapons: #{@NWEAPONSPROB}, " + \
            "\tFirst shot: #{@FIRSTSHOTPROB}"
    end

end # Dice

end # Deepspace