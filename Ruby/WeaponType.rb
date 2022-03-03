#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Enumeration of different weapons and their different programs.    | #
# +-------------------------------------------------------------------+ #

module WeaponType
    class Type
        #  Constructor or Initializer
        def initialize (the_power)
            @power = the_power
        end

        # Get function
        def power
            @power
        end
    end

    LASER   = Type.new(2.0)
    MISSILE = Type.new(3.0)
    PLASMA  = Type.new(4.0)
end
