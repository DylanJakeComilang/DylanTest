package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OneWheelSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveButtonCommand extends CommandBase {
    private OneWheelSubsystem wheel;
    private Timer timer;

    int iCount = 0;

    public MoveButtonCommand(OneWheelSubsystem wheel) {
        this.wheel = wheel;
        timer = new Timer();
        addRequirements(wheel);
    }

    @Override
    public void initialize() {
        iCount = 0;
        SmartDashboard.putString("Drive State", "Starting");
    }

    @Override
    public void execute() {
       /*  SmartDashboard.putString("Drive State", "Executing");
        SmartDashboard.putNumber("iCount", iCount);
        switch (iCount) {
            case 0:
                timer.reset();
                timer.start();
                iCount++;
                break;
            case 1:
                if (5 >= timer.get()) {
                    wheel.setForward();
                } else {
                    timer.reset();
                    timer.start();
                    iCount++;
                }
                break;
            case 2:
                if (2 >= timer.get()) {
                    wheel.setStop();
                } else {
                    timer.reset();
                    timer.start();
                    iCount++;
                }
                break;
            case 3:
                if (10 >= timer.get()) {
                    wheel.setBackward();
                } else {
                    iCount++;
                }
                break;
            case 4:
                wheel.setStop();
                iCount++;
                break;
        }*/
    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putString("Drive State", "Ending");
        
        iCount = 0;
    }

    @Override
    public boolean isFinished() {
        return iCount > 4;
    }
}
