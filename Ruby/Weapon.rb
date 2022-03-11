#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Class which represents the weapons a space station has to power   | #
# | up their energy at shooting.                                      | #
# +-------------------------------------------------------------------+ #

require_relative 'WeaponType.rb'

class Weapon
    def initialize(the_name, the_type, the_uses)
        @name = the_name
        @type = the_type
        @uses = the_uses
    end

    def self.newCopy(instance)
        new(instance.name, instance.type, instance.uses)
    end

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

    def useIt
        if @uses > 0
            @uses = @uses -1
            self.power
        else
            1
        end
    end
end

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