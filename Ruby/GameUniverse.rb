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

class GameUniverse

    @@WIN = 10
    @@INVALIDSTATIONINDEX = -1

    def initialize
        @currentStationIndex = @@INVALIDSTATIONINDEX
        @turns               = 0
        @dice                = Dice.new
        @gameState           = GameStateController.new
        @currentEnemy        = nil
        @spaceStations       = Array.new
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
        return nil
    end

    def discardShieldBooster(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardShieldBooster(i)
        end
        return nil
    end

    def discardShieldBoosterInHangar(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardHangarInHangar(i)
        end
        return nil
    end

    def discardWeapon(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardWeapon(i)
        end
        return nil
    end

    def discardWeaponInHangar(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.discardWeaponInHangar(i)
        end
        return nil
    end

    def getState
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
        return nil
    end

    def mountWeapon(i)
        if (@gameState.state == GameState::INIT || @gameState.state == GameState::AFTERCOMBAT)
            @currentStation.mountWeapon(i)
        end
        return nil
    end

    def nextTurn
        # TODO in P3
    end

    def to_s
        s = "["
        s += "turns: " + @turns.to_s + ", gameState: " + @gameState.to_s + ", dice: " + @dice.to_s
        s += ", currentEnemy: " + @currentEnemy.to_s + ", currentStationIndex: " + @currentStationIndex.to_s
        s += ", spaceStations: " + @spaceStations.to_s + ", currentStation: " + @currentStation.to_s 
        s += "]"
        return s
    end

end # GameUniverse

end # Deepspace
