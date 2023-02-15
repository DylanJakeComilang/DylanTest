package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorUpCommand extends CommandBase {
    /* 
    private ElevatorSubsystem elevator;
    private double speed;
    private int iCount;

    public ElevatorUpCommand(ElevatorSubsystem elevator, double speed) {
        this.elevator = elevator;
        this.speed = speed;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("Elevator State", "Starting");
        iCount = 0;
    }

    @Override
    public void execute() {
        SmartDashboard.putString("Elevator State", "Executing");
        SmartDashboard.putNumber("iCount", iCount);
        SmartDashboard.putNumber("Elevator Encoder", elevator.getEncoder());

        if (elevator.getEncoder() >= 50) {
            elevator.setStop();
        } else {
            elevator.setSpeed(speed);
        }

    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putString("Elevator State", "Ending");
        elevator.setStop();
        iCount = 0;

    }

    @Override
    public boolean isFinished() {
        if (iCount > 2) {
            return true;
        }
        return false;
    }
    */
}
