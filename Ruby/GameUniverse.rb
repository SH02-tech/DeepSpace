#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Description...                                                    | #
# +-------------------------------------------------------------------+ #

module Deepspace

require_relative "EnemyStarShip.rb"
require_relative "GameStateController.rb"
require_relative "CombatResult.rb"
require_relative "GameCharacter.rb"
require_relative "Dice.rb"
require_relative "ShotResult.rb"
require_relative "SpaceStation.rb"
require_relative "CardDealer.rb"

module GameUniverse

    @@WIN = 10

    def initialize()
        @currentStationIndex = -1 # TODO
        @turns               = 0
        @dice                = Dice.new
        @gameState           = GameStateController.new
        @currentEnemy        = nil
        @spaceStations       = nil
        @currentStation      = nil
    end

    def combatGo(station, enemy)
        # TODO in P3
    end

    def combat
        # TODO in P3
    end

    def discardHangar
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardHangar
        end
    end

    def discardShieldBooster(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardShieldBooster(i)
        end
    end

    def discardShieldBoosterInHangar(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardHangarInHangar(i)
        end
    end

    def discardWeapon(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardWeapon(i)
        end
    end

    def discardWeaponInHangar
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardWeaponInHangar(i)
        end
    end

    def state # TODO: name?
        @gameState.state
    end

    def getUIversion
        return GameUniverseToUI.new(self)
    end

    def haveAWinner
        @currentStation.nMedals >= @@WIN
    end

    def init(names)
        # TODO in P3
    end

    def mountShieldBooster(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.mountShieldBooster(i)
        end
    end

    def mountWeapon(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.mountWeapon(i)
        end
    end

    def nextTurn
        # TODO in P3
    end

end # GameUniverse

end # Deepspace