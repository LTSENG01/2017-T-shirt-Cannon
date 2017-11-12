package org.whsrobotics.tshirtcannon2017.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class GetStatus extends Command {

    public GetStatus() {
        super();
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

        // Pneumatics
        try {
            SmartDashboard.putBoolean("Compressor State", Pneumatics.getCompressorState());
            SmartDashboard.putNumber("Compressor Current", Pneumatics.getCompressorCurrent());
            SmartDashboard.putBoolean("Pressure Switch State", Pneumatics.getPressureSwitchState());
            SmartDashboard.putBoolean("Front Chamber Solenoid State", Pneumatics.getFrontChamberSolenoid().get());
            SmartDashboard.putBoolean("Sprinkler Valve State", Pneumatics.getSprinklerValveSolenoid().get());
        } catch (Exception ex) {
            System.err.println("Error with Pneumatics: " + ex);
        }

        // Drive Train



    }

    @Override
    protected void end() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
