#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | This class specifies the boosters of the shields of each space    | #
# | station.                                                          | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative "ShieldToUI.rb"

    class ShieldBooster

        @@DEFAULTBOOST = 1.0

        # Constructor 
        def initialize (the_name, the_boost, the_uses)
            @name  = the_name
            @boost = the_boost
            @uses  = the_uses
        end
        
        # Copy constructor
        def self.newCopy(instance)
            new(instance.name, instance.boost, instance.uses)
        end

        # Getters

        attr_reader :name, :boost, :uses

        # Decrease the uses of the shield
        def useIt 
            if @uses > 0
                @uses =- 1
                boost
            else
                @@DEFAULTBOOST
            end
        end

        def getUIversion
            return ShieldToUI.new(self)
        end

        # to_s method
        def to_s
            s = "["
            s += "Name: #{name}"
            s += "; Boost: #{boost}"
            s += "; Uses: #{uses}" 
            s += "]"
        end

    end # end of class ShiedlBooster

end # end of Deepspace