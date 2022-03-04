#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Class that represents a supplies package for a space station      | #
# +-------------------------------------------------------------------+ #

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

    # Get method
    
    def ammoPower
        @ammoPower
    end

    def fuelUnits
        @fuelUnits
    end

    def shieldPower
        @shieldPower
    end

end

# if __FILE__ == $0
    
#     supplies = SuppliesPackage.new(15,18,20)
#     supplies_2 = SuppliesPackage.newCopy(supplies) 

#     puts "info primer objeto:"
#     puts supplies.ammoPower
#     puts supplies.fuelUnits
#     puts supplies.shieldPower

#     puts "info segundo objeto:"
#     puts supplies_2.ammoPower
#     puts supplies_2.fuelUnits
#     puts supplies_2.shieldPower

# end
