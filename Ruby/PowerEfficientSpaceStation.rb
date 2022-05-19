#encoding:utf-8

module Deepspace

    class PowerEfficientSpaceStation < SpaceStation 

        @@EFFICIENCYFACTOR = 1.1

        def self.newCopy(station)
            super(station)
        end

        def fire
            super*@@EFFICIENCYFACTOR
        end

        def protection
            super*@@EFFICIENCYFACTOR
        end

        def setLoot(loot)
            super(loot)
            return Transformation::NOTRASNFORM
        end

    end # PowerEfficientSpaceStation

end # Deepspace
