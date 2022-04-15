#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | This class represents the Damage to a SpaceStation.               | #
# +-------------------------------------------------------------------+ #

module Deepspace

require_relative "WeaponType.rb"
require_relative "ShieldBooster.rb"

class Damage

    @@NOTUSED = -1

    # Constructors

    def initialize(w, s, wl)
        @nWeapons = w
        @nShields = s

        if (wl != nil)
            @weapons  = Array.new(wl)
        else
            @weapons = nil
        end
    end

    attr_reader :nShields, :nWeapons, :weapons

    def self.newNumericWeapons(w, s)
        new(w, s, nil)
    end

    def self.newSpecificWeapons(wl, s)
        new(@@NOTUSED, s, wl)
    end

    private_class_method :new

    def self.newCopy(d)
        if d.nWeapons == @@NOTUSED   # Using an array
            newSpecificWeapons(d.weapons, d.nShields)
        else # Not using an array
            newNumericWeapons(d.nWeapons, d.nShields)
        end
    end

    def getUIversion()
        DamageToUI.new(self)
    end

    def arrayContainsType(w, t)
        index = -1
        count = 0
        found = false
        while count < w.length && !found
            if (w[count].type == t)
                index = count
                found = true
            else
                count += 1
            end
        end
        return index
    end

    private :arrayContainsType

    def adjust(w, s)

        if nWeapons == @@NOTUSED   # Using an array
            
            weaponsCopy = Array.new(weapons)
            wCopy = Array.new(w)
            index = 0

            while index < weaponsCopy.length
                weaponType = weaponsCopy[index]
                pos = arrayContainsType(wCopy,weaponType)
                if pos >= 0
                    wCopy.delete_at(pos)
                    weaponsCopy.delete(weaponType)
                else
                    index += 1
                end
            end

            nShieldsCopy = nShields - s.length
            if nShieldsCopy < 0
                nShieldsCopy = 0
            end
            
            return Damage.newSpecificWeapons(weaponsCopy, nShieldsCopy)

        else  # Not using an array
            nWeaponsCopy = nWeapons - w.length
            if nWeaponsCopy < 0
                nWeaponsCopy = 0
            end

            nShieldsCopy = nShields - s.length
            if nShieldsCopy < 0
                nShieldsCopy = 0
            end

            return Damage.newNumericWeapons(nWeaponsCopy, nShieldsCopy)
        end
    end

    def discardWeapon(w)    # w : weaponn
        if @nWeapons == @@NOTUSED && @weapons.length > 0 # Using an array
            @weapons.delete(w.type)
        elsif @nWeapons > 0 # Not using an array
            @nWeapons -= 1
        end
        return nil
    end
    
    def discardShieldBooster()
        if @nShields > 0
            @nShields -=1
        end
        return nil
    end

    def hasNoEffect
        if nWeapons == @@NOTUSED # Using an array
            nShields == 0 && weapons.length == 0
        else # Not using an array
            nShields == 0 && nWeapons == 0
        end
    end

    def to_s

        if nWeapons == @@NOTUSED # TODO: to_s in WeaponType

            weaponsString = ""
            weapons.each do |w|
                case w
                when WeaponType::LASER
                    weaponsString += "LASER, "
                when WeaponType::MISSILE
                    weaponsString += "MISSILE, "
                when WeaponType::PLASMA
                    weaponsString += "PLASMA, "
                end
            end

            "DAMAGE: \n" + \
            "Number of shields: #{nShields} \n" + \
            "List of weapons: \n" + \
            "#{weaponsString}"
        else
            "DAMAGE: \n" + \
            "Number of weapons: #{nWeapons} \n" + \
            "Number of shields: #{nShields} \n"
        end
    end

end # Damage

end # Deepspace
