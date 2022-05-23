#encoding:utf-8

module Deepspace
    require_relative 'SpaceStation.rb'
    require_relative 'Transformation.rb'

    class SpaceCity < SpaceStation
        def initialize(base, rest)
            supplies = SuppliesPackage.new(base.ammoPower, base.fuelUnits, base.shieldPower)
            super(base, supplies)

            @base = base
            @collaborators = Array.new(rest)
        end
        
        attr_reader :collaborators

        def fire
            totalPower = super

            @collaborators.each do |c|
                totalPower += c.fire
            end

            return totalPower
        end
        
        def protection
            totalProtection = super

            @collaborators.each do |c|
                totalProtection += c.protection
            end

            return totalProtection
        end

        # Override
        def setLoot(loot)
            super
            return Transformation::NOTRANSFORM
        end
    end # SpaceCity
end # Deepspace