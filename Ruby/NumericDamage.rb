#encoding:utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Numeric Damage.                                                   | #
# +-------------------------------------------------------------------+ #

module Deepspace

require_relative 'Damage.rb'
require_relative 'Weapon.rb'
require_relative 'ShieldBooster.rb'
require_relative 'NumericDamageToUI.rb'

class NumericDamage < Damage
    
    # Override
    def initialize(theWeapons, theShields)
        super(theShields)
        @nWeapons = theWeapons
    end
    public_class_method :new

    attr_reader :nWeapons

    # Override
    def copy
        return NumericDamage.new(nWeapons, nShields)
    end

    # Override
    def getUIversion
        return NumericDamageToUI.new(self)
    end

    def adjustWeapons(theWeaponsArray)
        return [nWeapons,theWeaponsArray.length].min
    end

    private :adjustWeapons

    # Override
    def adjust(theWeaponsArray, theShieldsArray)
        numShields = super
        # numShields = newDamage.nShields
        numWeapons = adjustWeapons(theWeaponsArray)

        return NumericDamage.new(numWeapons, numShields)
    end

    # Override
    def discardWeapon(weapon)
        if @nWeapons > 0 
            @nWeapons -= 1
        else
            @nWeapons = 0
        end
    end

    # Override
    def hasNoEffect
        return (super && (nWeapons == 0))
    end
    
    # Override
    def to_s
        s = super

        s2 = s.sub("]", "")
        s2 += ", nWeapons: #{nWeapons}]"

        return s2
    end

end # End NumericDamage
end # End Deepspace

if $0 == __FILE__ then

    puts "--------------------------------------"
    puts "Constructor                           "
    puts "--------------------------------------"
    
    numDamage = Deepspace::NumericDamage.new(2,1)
    puts numDamage.to_s
    puts numDamage.inspect

    puts "\n\n"

    puts "--------------------------------------"
    puts "Copy                                  "
    puts "--------------------------------------"

    copyDamage = numDamage.copy

    puts copyDamage.inspect

    puts "\n\n"

    puts "--------------------------------------"
    puts "UI Version                            "
    puts "--------------------------------------"

    uiDamage = numDamage.getUIversion

    puts uiDamage.inspect

    puts "\n\n"

    puts "--------------------------------------"
    puts "Adjust                                "
    puts "--------------------------------------"

    s1 = Deepspace::ShieldBooster.new("Shield",2,3)
    w1 = Deepspace::Weapon.new("Weapon",Deepspace::WeaponType::LASER, 5)

    puts numDamage.adjust([w1,w1,w1], [s1,s1])

    puts "\n\n"

    puts "--------------------------------------"
    puts "Discards                              "
    puts "--------------------------------------"

    numDamage.discardShieldBooster
    numDamage.discardWeapon(2)

    puts numDamage.to_s

    # We shall empty the Damage shields and weapons.

    numDamage.discardShieldBooster
    numDamage.discardWeapon(2)
    numDamage.discardShieldBooster
    numDamage.discardWeapon(2)
    numDamage.discardShieldBooster
    numDamage.discardWeapon(2)

    puts numDamage.to_s + " (should be null)"

    puts "\n\n"

    puts "--------------------------------------"
    puts "NoEffect                              "
    puts "--------------------------------------"

    if numDamage.hasNoEffect
        puts "No effect (as expected)."
    else
        puts "Effect (NOT expected)."
    end
end  