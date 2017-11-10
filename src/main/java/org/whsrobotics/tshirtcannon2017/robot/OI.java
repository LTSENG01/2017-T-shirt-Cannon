package org.whsrobotics.tshirtcannon2017.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.whsrobotics.tshirtcannon2017.commands.SetDoubleSolenoid;
import org.whsrobotics.tshirtcannon2017.commands.SetSingleSolenoid;
import org.whsrobotics.tshirtcannon2017.commands.StartCompressor;
import org.whsrobotics.tshirtcannon2017.commands.StopCompressor;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class OI {

    public OI() {
        SmartDashboard.putData(new StartCompressor());
        SmartDashboard.putData(new StopCompressor());

        SmartDashboard.putData("Sprinkler Valve Solenoid - START", new SetSingleSolenoid(Pneumatics.getSprinklerValveSolenoid(), true));
        SmartDashboard.putData("Sprinkler Valve Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getSprinklerValveSolenoid(), false));

        SmartDashboard.putData("Front Chamber Solenoid - START", new SetSingleSolenoid(Pneumatics.getFrontChamberSolenoid(), true));
        SmartDashboard.putData("Front Chamber Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getFrontChamberSolenoid(), false));

//        SmartDashboard.putData("Front Chamber Solenoid - STOP", new SetDoubleSolenoid(Pneumatics.getFrontChamberSolenoid(), DoubleSolenoid.Value.kOff));
//        SmartDashboard.putData("Front Chamber Solenoid - FWD", new SetDoubleSolenoid(Pneumatics.getFrontChamberSolenoid(), DoubleSolenoid.Value.kForward));
//        SmartDashboard.putData("Front Chamber Solenoid - REV", new SetDoubleSolenoid(Pneumatics.getFrontChamberSolenoid(), DoubleSolenoid.Value.kReverse));
    }

}
