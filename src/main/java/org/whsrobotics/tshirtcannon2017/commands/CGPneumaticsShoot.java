package org.whsrobotics.tshirtcannon2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class CGPneumaticsShoot extends CommandGroup {

    public CGPneumaticsShoot() {

        // Charge - Timed, 0.5
        // Front Chamber - True
        // Sprinkler Valve - Timed, 0.5
        // Front Chamber - False
        // Ejector - Timed, 0.2

        addParallel(new TimedSolenoid(Pneumatics.getChargeCannonTankSolenoid(), 0.5));
        addParallel(new SetSingleSolenoid(Pneumatics.getFrontChamberSolenoid(), true));

        addSequential(new TimedSolenoid(Pneumatics.getSprinklerValveSolenoid(), 0.5));
        addSequential(new SetSingleSolenoid(Pneumatics.getFrontChamberSolenoid(), false));

        addSequential(new TimedSolenoid(Pneumatics.getShellEjectorSolenoid(), 0.2));

    }

}