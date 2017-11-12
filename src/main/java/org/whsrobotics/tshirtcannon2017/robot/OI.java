package org.whsrobotics.tshirtcannon2017.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.whsrobotics.tshirtcannon2017.commands.SetSingleSolenoid;
import org.whsrobotics.tshirtcannon2017.commands.StartCompressor;
import org.whsrobotics.tshirtcannon2017.commands.StopCompressor;
import org.whsrobotics.tshirtcannon2017.commands.TimedSolenoid;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class OI {

    public OI() {
        SmartDashboard.putData(new StartCompressor());
        SmartDashboard.putData(new StopCompressor());

        SmartDashboard.putData("Sprinkler Valve Solenoid - START", new SetSingleSolenoid(Pneumatics.getSprinklerValveSolenoid(), true));
        SmartDashboard.putData("Sprinkler Valve Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getSprinklerValveSolenoid(), false));

        // Should open and close the sprinkler valve according to the timeout.
        SmartDashboard.putData("Sprinkler Valve Solenoid - TIMED 0.5 SEC", new TimedSolenoid(Pneumatics.getSprinklerValveSolenoid(), 0.5));

        SmartDashboard.putData("Front Chamber Solenoid - START", new SetSingleSolenoid(Pneumatics.getFrontChamberSolenoid(), true));
        SmartDashboard.putData("Front Chamber Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getFrontChamberSolenoid(), false));

        SmartDashboard.putData("Charge Cannon Solenoid - START", new SetSingleSolenoid(Pneumatics.getChargeCannonTankSolenoid(), true));
        SmartDashboard.putData("Charge Cannon Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getChargeCannonTankSolenoid(), false));

    }

}
