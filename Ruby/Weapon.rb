#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Class which represents the weapons a space station has to power   | #
# | up their energy at shooting.                                      | #
# +-------------------------------------------------------------------+ #

module Deepspace
    
require_relative 'WeaponType.rb'

class Weapon

    # Constructor
    def initialize(the_name, the_type, the_uses)
        @name = the_name
        @type = the_type
        @uses = the_uses
    end

    # Copy constructor 
    def self.newCopy(instance)
        new(instance.name, instance.type, instance.uses)
    end

    # Getters
    def name
        @name
    end

    def type
        @type
    end

    def uses
        @uses
    end

    def power
        @type.power
    end

    # It decreases the uses of the weapon.
    def useIt
        if @uses > 0
            @uses = @uses -1
            self.power
        else
            return 1
        end
    end

    def getUIversion
        return WeaponToUI.new(self)
    end

    # to_s method
    def to_s

        if type == WeaponType::LASER
            typeName = "LASER"
        elsif type == WeaponType::MISSILE
            typeName = "MISSILE"
        else
            typeName = "PLASMA"
        end

        return "Weapon => Name: #{name}, Type: #{typeName}, Uses: #{uses}."
    end

end

    ### TEST PROGRAM
    # w = Weapon.new("weapon", "Laser", 10)
    # puts w.to_s

end # end of Deepspace

=begin TESTS 
test = Weapon.new("URS2", WeaponType::MISSILE, 0)
puts test.inspect
puts test.uses
puts test.useIt
puts test.uses

test2 = Weapon.newCopy(test)
puts test2.inspect
puts test2.uses
puts test2.useIt
puts test2.uses
=end