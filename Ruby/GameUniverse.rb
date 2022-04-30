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

    def combatGo(station, enemy)    # P3
        ch = @dice.firstShot
        enemyWins = nil 
        combatResult = nil
        if ch == GameCharacter::ENEMYSTARSHIP
            fire = enemy.fire
            result = station.receiveShot(fire)
            if result == ShotResult::RESIST
                fire = station.fire
                result = enemy.receiveShot(fire)
                enemyWins = (result == ShotResult::RESIST)
            else
                enemyWins = true
            end
        else
            fire = station.fire
            result = enemy.receiveShot(fire)
            enemyWins = (result == ShotResult::RESIST)
        end
        if enemyWins
            s = station.getSpeed
            moves = @dice.spaceStationMoves(s)
            if !moves
                damage = enemy.damage
                station.setPendingDamage(damage)
                combatResult = CombatResult::ENEMYWINS
            else
                station.move
                combatResult = CombatResult::STATIONESCAPES
            end
        else
            aLoot = enemy.loot
            station.setLoot(aLoot)
            combatResult = CombatResult::STATIONWINS
        end
        @gameState.next(@turns, @spaceStations.length)
        return combatResult
    end

    def combat  # P3
        state = @gameState.state
        if (state == GameState::BEFORECOMBAT || state == GameState::INIT)
            return combatGo(@currentStation, @currentEnemy)
        else
            return CombatResult::NOCOMBAT
        end
    end

    def discardHangar
        state = @gameState.state
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardHangar
        end
        return nil
    end

    def discardShieldBooster(i)
        state = @gameState.state
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardShieldBooster(i)
        end
        return nil
    end

    def discardShieldBoosterInHangar(i)
        state = @gameState.state
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardHangarInHangar(i)
        end
        return nil
    end

    def discardWeapon(i)
        state = @gameState.state
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardWeapon(i)
        end
        return nil
    end

    def discardWeaponInHangar(i)
        state = @gameState.state
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardWeaponInHangar(i)
        end
        return nil
    end

    def getState
        gameState.state
    end

    def getUIversion
        GameUniverseToUI.new(self)
    end

    def haveAWinner
        @currentStation.nMedals >= @@WIN
    end

    def init(names) # P3    
        if @gameState.state == GameState::CANNOTPLAY
            dealer = CardDealer.new
            names.each do |name|
                supplies = dealer.nextSuppliesPackage
                station  = SpaceStation.new(name, supplies)
                nh = @dice.initWithNHangars
                nw = @dice.initWithNWeapons
                ns = @dice.initWithNShields
                lo = Loot.new(0, nw, ns, nh, 0)
                station.setLoot(lo)
                @spaceStations << station
            end
            currentStationIndex = @dice.whoStarts(names.lenght)
            currentStation      = @spaceStations.at(currentStationIndex)
            currentEnemy        = dealer.nextEnemy
            @gameState.next(@turns, @spaceStations.length)
        end
    end

    def mountShieldBooster(i)
        state = @gameState.state
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.mountShieldBooster(i)
        end
        return nil
    end

    def mountWeapon(i)
        state = @gameState.state
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.mountWeapon(i)
        end
        return nil
    end

    def nextTurn    # P3
        changeTurn = false
        if @gameState.state == GameState::AFTERCOMBAT
            if @currentStation.validState
                @currentStationIndex = (@currentStationIndex + 1) % @spaceStations.lenght
                turns += 1
                @currentStation = @spaceStations.at(currentStationIndex)
                @currentStation.cleanUpMountedItems
                dealer = CardDealer.new
                @currentEnemy = dealer.nextEnemy
                @gameState.next(turns, @spaceStations.lenght)
                changeTurn = true
            end
        end
        return changeTurn
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
