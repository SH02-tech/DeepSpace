#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | This class specifies the characteristics of an Hangar.            | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative 'ShieldBooster.rb'
    require_relative 'Weapon.rb'
    require_relative 'HangarToUI.rb'

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
            mod = new(h.maxElements)

            h.shieldBoosters.each do |s|
                mod.addShieldBooster(s)
            end

            h.weapons.each do |w|
                mod.addWeapon(w)
            end

            return mod
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
                @weapons << Weapon.newCopy(w)
                return true
            else
                return false
            end
        end

        def addShieldBooster(s)
            if spaceAvailable()
                @shieldBoosters << ShieldBooster.newCopy(s)
                return true
            else
                return false
            end
        end

        def removeShieldBooster(s)
            if 0<=s && s<@shieldBoosters.size
                @shieldBoosters.delete_at(s)
            else
                return nil
            end
            
        end

        def removeWeapon(w)
            if 0<=w && w<@weapons.size
                @weapons.delete_at(w)
            else
                return nil
            end
        end

        def to_s
            s = "["
            s += "maxElements: " + @maxElements.to_s
            s += "; shieldBoosters: " + @shieldBoosters.to_s
            s += "; weapons: " + @weapons.to_s
            s += "]"

            return s
        end

    end # end of Hangar
 
end # end of Deepspace
