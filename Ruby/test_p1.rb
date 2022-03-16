#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Test program of the methods.                                      | #
# +-------------------------------------------------------------------+ #

module Deepspace

require_relative 'CombatResult.rb'
require_relative 'Dice.rb'
require_relative 'GameCharacter.rb'
require_relative 'Loot.rb'
require_relative 'ShieldBooster.rb'
require_relative 'ShotResult.rb'
require_relative 'SuppliesPackage.rb'
require_relative 'Weapon.rb'
require_relative 'WeaponType.rb'

class TestP1
    def initialize
    end

    def self.main
        puts 'Probando clase enumerada COMBAT RESULT: '
        
        combat_result = CombatResult::ENEMYWINS
        puts combat_result

        combat_result = CombatResult::NOCOMBAT
        puts combat_result

        combat_result = CombatResult::STATIONESCAPES
        puts combat_result

        combat_result = CombatResult::STATIONWINS
        puts combat_result

        puts 'Probando LOOT: '

        loot = Loot.new(2, 3, 2, 2, 2)
        puts 'Supplies: ' + (loot.nSupplies).to_s
        puts 'Weapons: ' + loot.nWeapons.to_s
        puts 'Shields: ' + loot.nShields.to_s
        puts 'Hangars: ' + loot.nHangars.to_s
        puts 'Medals: ' + loot.nMedals.to_s
        puts 'Inspección: ' + loot.inspect

        puts '\nProbando SHIELDBOOSTER:'

        shield_booster = ShieldBooster.new("Escudo", 14, -1)
        puts shield_booster.inspect
        puts (shield_booster.useIt)
        puts (shield_booster.uses)
        
        
        shield_booster_2 = ShieldBooster.new("Caja", 12, 12)
        puts shield_booster_2.inspect
        shield_booster_2 = ShieldBooster.newCopy(shield_booster)
        puts shield_booster_2.inspect
        
        puts shield_booster_2.boost

        puts 'Inspección objeto: ' + shield_booster.inspect
        puts 'Inspección objeto: ' + shield_booster_2.inspect

        puts 'Probando SUPPLIESPACKAGE:'

        supplies = SuppliesPackage.new(15,18,20)
        supplies_2 = SuppliesPackage.newCopy(supplies) 

        puts "info primer objeto:"
        puts supplies.ammoPower
        puts supplies.fuelUnits
        puts supplies.shieldPower

        puts "info segundo objeto:"
        puts supplies_2.ammoPower
        puts supplies_2.fuelUnits
        puts supplies_2.shieldPower

        puts 'Inspección objeto: ' + supplies.inspect

        puts 'Probando clase WEAPON: '

        weapon = Weapon.new("URS2", WeaponType::MISSILE, 0)
        puts weapon.inspect
        puts weapon.uses
        puts weapon.useIt
        puts weapon.uses

        weapon_copy = Weapon.newCopy(weapon)
        puts weapon_copy.inspect
        puts weapon_copy.uses
        puts weapon_copy.useIt
        puts weapon_copy.uses

        puts 'Inspección objeto: ' + weapon.inspect

        puts 'Probando WEAPONTYPE: '
        weapon_laser = WeaponType::LASER
        weapon_missile = WeaponType::MISSILE
        weapon_plasma = WeaponType::PLASMA

        puts 'LASER: ' + weapon_laser.inspect
        puts 'MISSILE: ' + weapon_missile.inspect
        puts 'PLASMA: ' + weapon_plasma.inspect

        # Now we shall use the dice.

        spacecraft_speed = 0.4
        num_players = 65

        no_hangars = 0
        no_shield = 0
        
        num_weapons = [0, 0, 0, 0] 
        # num_weapons[0]: 0 weapons
        # num_weapons[1]: 1 weapon
        # num_weapons[2]: 2 weapons
        # num_weapons[3]: 3 weapons

        starting_player = []
        evaded_attack = 0

        dice = Dice.new

        for i in (1..100)
            if dice.initWithNHangars == 0
                no_hangars += 1
            end
            
            if dice.initWithNShields == 0
                no_shield += 1
            end

            if dice.spaceStationMoves(spacecraft_speed)
                evaded_attack += 1
            end

            num_weapons[dice.initWithNWeapons] += 1
            starting_player.push(dice.whoStarts(num_players))
        end

        puts 'Imprimiendo datos obtenidos del dado: '
        puts 'No Hangars situation: ' + no_hangars.to_s + ' (expected 25).'
        puts 'No Shield situation: ' + no_shield.to_s + ' (expected 25).'
        puts 'Weapons: ' + num_weapons.to_s + '(expected [0, 33, 33, 34]).'
        puts 'Evaded attacks: ' + evaded_attack.to_s + ' (expected ' + (spacecraft_speed*100).to_s + ').'
        puts 'Inspect dice: ' + dice.inspect
    end
end

TestP1.main