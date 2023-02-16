package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorTopCommand extends CommandBase {
    private ElevatorSubsystem elevator;
    private int iCount;

    public ElevatorTopCommand(ElevatorSubsystem elevator) {
        this.elevator = elevator;
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
        elevator.outputMotor(200);
        }
    

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putString("Elevator State", "Ending");
        elevator.setStop();
        iCount = 0;

    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}
