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

    # Constructors

    private_class_method :new

    def initialize(s)
        @nShields = s
    end

    attr_reader :nShields

    # TODO
    def copy()
    end

    def getUIversion()
    end

    def adjustShields(s)
        return [nShields,s.length].min
    end
    private :adjustShields

    # TODO
    def adjust(w, s)    # s : shieldBooster[] 
        adjustShields(s)
    end
    
    def discardShieldBooster()
        if @nShields > 0
            @nShields -= 1
        else
            @nShields = 0
        end
        return nil
    end

    def discardWeapon(weapon)
    end

    def hasNoEffect
        nShields == 0
    end

    def to_s
        return "[nShields: #{nShields}]"
    end

end # Damage

end # Deepspace
