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
require_relative "SpaceCity.rb"
require_relative "CardDealer.rb"
require_relative "GameUniverseToUI.rb"
require_relative "Transformation.rb"
require_relative 'PowerEfficientSpaceStation.rb'
require_relative 'BetaPowerEfficientSpaceStation.rb'

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
        @haveSpaceCity       = false
    end

    def createSpaceCity
        if !@haveSpaceCity
           collaborators = Array.new
           for i in (0..@currentStationIndex-1) do
            collaborators.push(@spaceStations.at(i))
           end
           for i in (@currentStationIndex+1..@spaceStations.length-1) do
            collaborators.push(@spaceStations.at(i))  
           end

           spaceCity = SpaceCity.new(@currentStation, collaborators)
           @spaceStations[@currentStationIndex] = spaceCity
           @currentStation = @spaceStations.at(@currentStationIndex)
           @haveSpaceCity = true
        end
    end

    private :createSpaceCity

    def makeStationEfficient
        if @dice.extraEfficiency # bettaEfficient
            newStation = BetaPowerEfficientSpaceStation.newCopy(@currentStation)
        else #normalEfficeint
            newStation = PowerEfficientSpaceStation.newCopy(@currentStation)
        end
        @spaceStations[@currentStationIndex] = newStation
        @currentStation = @spaceStations.at(@currentStationIndex)
    end

    private :makeStationEfficient

    def combatGo(station, enemy) 
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
            transformation = station.setLoot(aLoot)
            case transformation
            when Transformation::GETEFFICIENT
                makeStationEfficient
                combatResult = CombatResult::STATIONWINSANDCONVERT
            when Transformation::SPACECITY
                createSpaceCity
                combatResult = CombatResult::STATIONWINSANDCONVERT
            else
                combatResult = CombatResult::STATIONWINS
            end
        end
        @gameState.next(@turns, @spaceStations.length)
        return combatResult
    end

    def combat
        if (state == GameState::BEFORECOMBAT || state == GameState::INIT)
            return combatGo(@currentStation, @currentEnemy)
        else
            return CombatResult::NOCOMBAT
        end
    end

    def discardHangar
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardHangar
        end
        return nil
    end

    def discardShieldBooster(i)
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardShieldBooster(i)
        end
        return nil
    end

    def discardShieldBoosterInHangar(i)
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardShieldBoosterInHangar(i)
        end
        return nil
    end

    def discardWeapon(i)
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardWeapon(i)
        end
        return nil
    end

    def discardWeaponInHangar(i)
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.discardWeaponInHangar(i)
        end
        return nil
    end

    def state
        @gameState.state
    end

    def getUIversion
        GameUniverseToUI.new(@currentStation, @currentEnemy)
    end

    def haveAWinner
        @currentStation.nMedals >= @@WIN
    end

    def init(names) 
        if state == GameState::CANNOTPLAY
            dealer = CardDealer.instance
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
            @currentStationIndex = @dice.whoStarts(names.length)
            @currentStation      = @spaceStations.at(@currentStationIndex)
            @currentEnemy        = dealer.nextEnemy
            @gameState.next(@turns, @spaceStations.length)
        end
    end

    def mountShieldBooster(i)
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.mountShieldBooster(i)
        end
        return nil
    end

    def mountWeapon(i)
        if (state == GameState::INIT || state == GameState::AFTERCOMBAT)
            @currentStation.mountWeapon(i)
        end
        return nil
    end

    def nextTurn
        changeTurn = false
        if state == GameState::AFTERCOMBAT
            if @currentStation.validState
                @currentStationIndex = (@currentStationIndex + 1) % @spaceStations.length
                @turns += 1
                @currentStation = @spaceStations.at(@currentStationIndex)
                @currentStation.cleanUpMountedItems
                dealer = CardDealer.instance
                @currentEnemy = dealer.nextEnemy
                @gameState.next(@turns, @spaceStations.length)
                changeTurn = true
            end
        end
        return changeTurn
    end

    def to_s

        cadSpaceStations = ""
        @spaceStations.each do |station|
            cadSpaceStations += station.to_s
        end

        s = "["
        s += "turns: " + @turns.to_s + ", gameState: " + state.to_s + ", dice: " + @dice.to_s
        s += ", currentEnemy: " + @currentEnemy.to_s + ", currentStationIndex: " + @currentStationIndex.to_s
        s += ", spaceStations: " + cadSpaceStations + ", currentStation: " + @currentStation.to_s 
        s += "]"
        return s
    end

end # GameUniverse

end # Deepspace
