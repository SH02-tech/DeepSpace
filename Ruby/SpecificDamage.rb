#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Specific Damage.                                                  | #
# +-------------------------------------------------------------------+ #


module Deepspace

require_relative 'Damage.rb'
require_relative 'Weapon.rb'
require_relative 'ShieldBooster.rb'
require_relative 'SpecificDamageToUI.rb'

class SpecificDamage < Damage
    def initialize(wl,s)
        super(s)
        if wl != nil
            @weapons = Array.new(wl)
        else
            @weapons = Array.new
        end
    end

    public_class_method :new

    attr_reader :weapons

    # Override
    def copy
        return SpecificDamage.new(weapons, nShields)
    end

    # Override
    def getUIversion
        return SpecificDamageToUI.new(self)
    end

    def arrayContainsType(weapon_arr, type)
        index = -1
        count = 0
        found = false
        while count < weapon_arr.length && !found
            if (weapon_arr[count].type == type)
                index = count
                found = true
            else
                count += 1
            end
        end
        return index
    end

    private :arrayContainsType

    # Override
    def adjust(theWeaponsArray, theShieldsArray)
        nShieldsCopy = super

        weaponsCopy = Array.new(weapons)
        wCopy = Array.new(theWeaponsArray)
        index = 0

        while index < weaponsCopy.length
            weaponType = weaponsCopy[index]
            pos = arrayContainsType(wCopy,weaponType)
            if pos >= 0
                wCopy.delete_at(pos)
                index += 1
            else
                weaponsCopy.delete_at(index)
            end
        end

        return SpecificDamage.new(wCopy, nShieldsCopy)
    end

    # Override
    def discardWeapon(weapon)
        index = arrayContainsType(@weapons, weapon.type)

        if index >= 0
            @weapons.delete_at(index)
        end
    end

    # Override
    def hasNoEffect
        return (super && (weapons.length == 0))
    end

    # Override
    def to_s
        s = super
        s2 = s.sub("]", "")

        weaponsString = ""
        weapons.each do |w|
            weaponsString += "#{w.to_s}, "
        end
        
        s2 += "; weaponsType: #{weaponsString}]"

        return s2
    end

end # SpecificDamage
end # Deepspace

if $0 == __FILE__ then

    w1 = Deepspace::Weapon.new("Laser 1", Deepspace::WeaponType::LASER, 10)
    w2 = Deepspace::Weapon.new("Laser 2", Deepspace::WeaponType::LASER, 20)
    w3 = Deepspace::Weapon.new("Missile 1", Deepspace::WeaponType::MISSILE, 10)
    w4 = Deepspace::Weapon.new("Missile 2", Deepspace::WeaponType::MISSILE, 10)
    
    s1 = Deepspace::ShieldBooster.new("ShieldBooster 1", 10, 2)
    s2 = Deepspace::ShieldBooster.new("ShieldBooster 2", 20, 7)

    puts '-----------------------------------------------'
    puts 'Constructor'
    puts '-----------------------------------------------'
    specDamage = Deepspace::SpecificDamage.new([w1,w2,w3,w4], 10)
    puts specDamage.to_s

    puts "\n\n"

    puts '-----------------------------------------------'
    puts 'Copy'
    puts '-----------------------------------------------'
    copyDamage = specDamage.copy
    puts copyDamage.to_s

    puts "\n\n"

    puts '-----------------------------------------------'
    puts 'UI version'
    puts '-----------------------------------------------'
    uiDamage = specDamage.getUIversion
    puts uiDamage.to_s

    puts "\n\n"

    puts '-----------------------------------------------'
    puts 'Adjust'
    puts '-----------------------------------------------'
    
    adjustDamage = specDamage.adjust([w1], [s1,s2])

    puts adjustDamage.to_s
    puts specDamage.to_s

    puts "\n\n"

    
    
end # Test