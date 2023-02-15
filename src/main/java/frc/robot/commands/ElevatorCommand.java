package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends CommandBase {
   /* 
    private ElevatorSubsystem elevator;
    double speed;
    private int iCount;

    public ElevatorCommand(ElevatorSubsystem elevator, double speed) {
        this.speed = speed;
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("Elevator State", "Starting");
        elevator.resetEncoder();
        iCount = 0;
    }

    @Override
    public void execute() {
        SmartDashboard.putString("Elevator State", "Executing");
        SmartDashboard.putNumber("iCount", iCount);
        SmartDashboard.putNumber("Encoder Count", elevator.getEncoder());

        switch (iCount) {
            case 0:

                if(elevator.getEncoder() >= 11){
                    elevator.setSpeed(-speed);
                }
                else if(elevator.getEncoder() <= 9){
                    elevator.setSpeed(speed);
                }
                else{
                    elevator.setStop();
                }

        }

    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putString("Elevator State", "Ending");
        elevator.setStop();
        elevator.resetEncoder();
        iCount = 0;

    }

    @Override
    public boolean isFinished() {
        if (iCount > 2) {
            return true;
        }
        return false;
    } */
}
