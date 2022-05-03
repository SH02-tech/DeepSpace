#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Enumeration of different weapons and their different programs.    | #
# +-------------------------------------------------------------------+ #

module Deepspace

    module WeaponType

        class Type

            #  Constructor or Initializer
            def initialize (the_power, the_name)
                @power = the_power
                @name  = the_name
            end

            # Get function
            def power
                @power
            end

            # to_s method
            def to_s
                "#{@name}"
            end

        end

        LASER   = Type.new(2.0, "LASER")
        MISSILE = Type.new(3.0, "MISSILE")
        PLASMA  = Type.new(4.0, "PLASMA")
    end

end # end of Deepspace