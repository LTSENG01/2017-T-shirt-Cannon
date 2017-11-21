package org.whsrobotics.tshirtcannon2017.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.whsrobotics.tshirtcannon2017.commands.*;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;
import org.whsrobotics.tshirtcannon2017.utils.XboxController;

public class OI {

    public static XboxController xboxController;

    public OI() {
        xboxController = new XboxController(0);
        xboxController.getButton(XboxController.Buttons.A).whenPressed(new CGPneumaticsShoot());
        xboxController.getButton(XboxController.Buttons.LEFT_BUMPER).whenPressed(new StopCompressor());
        xboxController.getButton(XboxController.Buttons.RIGHT_BUMPER).whenPressed(new StartCompressor());

        //TODO: Bind Commands to Controller!!!
        SmartDashboard.putData(new StartCompressor());
        SmartDashboard.putData(new StopCompressor());

        SmartDashboard.putData(new CGPneumaticsShoot());


        // Extra Commands

        SmartDashboard.putData("Sprinkler Valve Solenoid - START", new SetSingleSolenoid(Pneumatics.getSprinklerValveSolenoid(), true));
        SmartDashboard.putData("Sprinkler Valve Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getSprinklerValveSolenoid(), false));

        SmartDashboard.putData("Sprinkler Valve Solenoid - TIMED 0.5 SEC", new TimedSolenoid(Pneumatics.getSprinklerValveSolenoid(), 0.5));

        SmartDashboard.putData("Front Chamber Solenoid - START", new SetSingleSolenoid(Pneumatics.getFrontChamberSolenoid(), true));
        SmartDashboard.putData("Front Chamber Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getFrontChamberSolenoid(), false));

        SmartDashboard.putData("Shell Ejector Solenoid - START", new SetSingleSolenoid(Pneumatics.getShellEjectorSolenoid(), true));
        SmartDashboard.putData("Shell Ejector Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getShellEjectorSolenoid(), false));

        SmartDashboard.putData("Charge Cannon Solenoid - START", new SetSingleSolenoid(Pneumatics.getChargeCannonTankSolenoid(), true));
        SmartDashboard.putData("Charge Cannon Solenoid - STOP", new SetSingleSolenoid(Pneumatics.getChargeCannonTankSolenoid(), false));

    }

}
