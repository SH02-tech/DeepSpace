#encoding: utf-8

# +-------------------------------------------------------------------+ #
# | DEEPSPACE (Ruby)                                                  | #
# | Authors: Shao Jie Hu Chen and Mario Megías Mateo                  | #
# +-------------------------------------------------------------------+ #
# | Description...                                                    | #
# +-------------------------------------------------------------------+ #

module Deepspace

    require_relative 'ShieldBooster.rb'
    require_relative 'Weapon.rb'

    class Hangar

        # Constructor
        def initialize(capacity)
            @maxElements = capacity
            @shieldBoosters = []
            @weapons = []
        end

        # Copy constructor
        def self.newCopy(h)
            new(h.capacity)
        end

        def getUIversion
            HangarToUI.new(self)
        end

        def spaceAvailable 
            shieldBoosters.length + weapons.length < maxElements
        end

        def addWeapon(w)
            if spaceAvailable()
                @weapons << w
                return true
            else
                return false
            end
        end

        def addShieldBooster(w)
            if spaceAvailable()
                @shieldBoosters << w 
                return true
            else
                return false
            end
        end

        def removeShieldBooster(s)
            @shieldBoosters.delete_at(s)
        end

        def removeWeapon(w)
            @weapons.delete_at(w)
        end

        def to_s
            shieldString = ""
            weaponString = ""

            shieldBoosters.each do |s|
                shieldString = shieldString + "#{s.to_s}\n"
            end

            weapons.each do |w|
                weaponString = weaponString + "#{w.to_s}\n"
            end

            "HANGAR:\n" + \
            "Maximum of elements: #{maxElements}\n#{shieldString}#{weaponString}"
        end

        attr_reader :maxElements, :shieldBoosters, :weapons

    end

    ### TESTING

    # s1 = ShieldBooster.new("Potenciador1", 10.5, 5)
    # s2 = ShieldBooster.new("Potenciador2", 10.5, 5)
    # w1 = Weapon.new("arma1", WeaponType::LASER, 5)

    # h = Hangar.new(3)

    # h.addShieldBooster(s1)
    # h.addShieldBooster(s2)
    # h.addWeapon(w1)

    # puts h.to_s
    # puts

    # var = h.removeShieldBooster(1)
    # puts "Escudo eliminado: #{var}"

    # var2 = h.removeWeapon(1)
    # if var2 == nil
    #     puts "El arma a eliminar no existe"
    # end

    # puts
    # puts h.to_s
    # puts

    # weapons = h.weapons
    # weapons.each do |w|
    #     puts "#{w.to_s}\n"
    # end
 
end

 