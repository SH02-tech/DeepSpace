#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Description...                                                    | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative 'ShieldBooster.rb'
    require_relative 'Weapon.rb'

    class Hangar

        # Initialize
        def initialize(capacity)
            @maxElements    = capacity
            @shieldBoosters = Array.new
            @weapons        = Array.new
        end

        attr_reader :maxElements, :shieldBoosters, :weapons

        # Copy constructor
        def self.newCopy(h)
            new(h.maxElements)
        end

        def getUIversion
            HangarToUI.new(self)
        end

        def spaceAvailable 
            shieldBoosters.length + weapons.length < maxElements
        end

        private :spaceAvailable 

        def addWeapon(w)
            if spaceAvailable()
                @weapons << w
                return true
            else
                return false
            end
        end

        def addShieldBooster(w)
            if spaceAvailable()
                @shieldBoosters << w 
                return true
            else
                return false
            end
        end

        def removeShieldBooster(s)
            @shieldBoosters.delete_at(s)
        end

        def removeWeapon(w)
            @weapons.delete_at(w)
        end

        def to_s
            shieldString = ""
            weaponString = ""

            shieldBoosters.each do |s|
                shieldString = shieldString + "#{s.to_s}\n"
            end

            weapons.each do |w|
                weaponString = weaponString + "#{w.to_s}\n"
            end

            "HANGAR:\n" + \
            "Maximum of elements: #{maxElements}\n#{shieldString}#{weaponString}"
        end

    end # end of Hangar
 
end # end of Deepspace
