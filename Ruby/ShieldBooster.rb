#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | This class specifies the boosters of the shields of each space    | #
# | station.                                                          | #
# +-------------------------------------------------------------------+ #

module Deepspace

class ShieldBooster

    def initialize (the_name, the_boost, the_uses)
        @name  = the_name
        @boost = the_boost
        @uses  = the_uses
    end

    def self.newCopy (instance)
        new(instance.name, instance.boost, instance.uses)
    end

    def name
        @name
    end

    def boost
        @boost
    end

    def uses
        @uses
    end

    def useIt 
        if @uses > 0
            @uses = @uses - 1
            @boost
        else
            return 1
        end
    end
end

end # end of Deepspace

=begin TEST
test = ShieldBooster.new("Escudo", 14, -1)
puts test.inspect
puts (test.useIt)
puts (test.uses)


test2 = ShieldBooster.new("Caja", 12, 12)
puts test2.inspect
test2 = ShieldBooster.newCopy(test)
puts test2.inspect

puts test2.boost
=end