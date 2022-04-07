#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Class that represents a supplies package for a space station      | #
# +-------------------------------------------------------------------+ #

module Deepspace

    class SuppliesPackage

        # Constructor
        def initialize (the_ammoPower, the_fuelUnits, the_ShieldPower)
            @ammoPower   = the_ammoPower
            @fuelUnits   = the_fuelUnits
            @shieldPower = the_ShieldPower
        end

        # Copy constructor
        def self.newCopy (instance)
            new(instance.ammoPower, instance.fuelUnits, instance.shieldPower)
        end

        # Getters
        attr_reader :ammoPower, :fuelUnits, :shieldPower
        
        # to_s method
        def to_s
            return "Ammo power: #{ammoPower}, \tFuel units: #{fuelUnits}, \tShield Power: #{shieldPower}."
        end

    end # end of class SuppliesPackage

end # end of Deepspace
