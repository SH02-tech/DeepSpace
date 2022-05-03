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
require_relative "DamageToUI.rb"

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

        def self.newSpecificWeapons(wl, s)  # wl : WeaponType[]
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

        def arrayContainsType(w, t)     # w : Weapon[], t :WeaponType
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

        def adjust(w, s)    # w : Weapon[], s : shieldBooster[] 

            if nWeapons == @@NOTUSED   # Using an array
                
                weaponsCopy = Array.new(weapons)
                wCopy = Array.new(w)
                index = 0

                while index < weaponsCopy.length
                    weaponType = weaponsCopy[index]
                    pos = arrayContainsType(wCopy,weaponType)
                    if pos >= 0
                        wCopy.delete_at(pos)
                        index += 1
                    else
                        weaponsCopy.delete(weaponType)
                    end
                end

                nShieldsCopy = [nShields,s.length].min
                
                return Damage.newSpecificWeapons(weaponsCopy, nShieldsCopy)

            else  # Not using an array
                nWeaponsCopy = [nWeapons,w.length].min

                nShieldsCopy = [nShields,s.length].min

                return Damage.newNumericWeapons(nWeaponsCopy, nShieldsCopy)
            end
        end

        def discardWeapon(w)    # w : weaponn
            if @nWeapons == @@NOTUSED && @weapons.length > 0 # Using an array
                @weapons.delete(w.type)
            else  # Not using an array
                if @nWeapons > 0 
                    @nWeapons -= 1
                else
                    @nWeapons = 0
                end
            end
            return nil
        end
        
        def discardShieldBooster()
            if @nShields > 0
                @nShields -= 1
            else
                @nShields = 0
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
                    weaponsString += "#{w.to_s}, "
                end

                s = "["
                s += "nShields: #{nShields}"
                s += "; weaponsType: #{weaponsString}"
                s += "]"
                return s
            else
                s = "["
                s += "nShields: #{nShields}"
                s += "; nWeapons: #{nWeapons}"
                s += "]"
                return s
            end
        end

    end # Damage

end # Deepspace
