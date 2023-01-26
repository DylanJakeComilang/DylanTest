// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.MoveButtonCommand;
import frc.robot.commands.TankCommand;
import frc.robot.commands.ArcadeCommand;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.ArmDownCommand;
import frc.robot.commands.ArmUpCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.ElevatorTopCommand;
import frc.robot.commands.ElevatorMiddleCommand;
import frc.robot.commands.ElevatorHybridCommand;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.OneWheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final DriveSubsystem driveSubsystem= new DriveSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  //private final OneWheelSubsystem oneWheelSubsystem = new OneWheelSubsystem(0.5);
  private final XboxController xbox = new XboxController(1);

  public RobotContainer() {
   // driveSubsystem.setDefaultCommand(new ArcadeCommand(driveSubsystem, () -> xbox.getLeftY(), () -> xbox.getRightX())); //set arcade drive

    configureBindings();
    
  }

  private void configureBindings() {
   // new JoystickButton(xbox, 5).onTrue(new MoveButtonCommand(oneWheelSubsystem)); 
   
   //when button 5 is held, controlls are now tank
    //new JoystickButton(xbox, 5).onTrue(new TankCommand(driveSubsystem, () -> xbox.getRightY(), () -> xbox.getLeftY()));

   //right trigger sets motor down, right bumper sets motor up
   //new JoystickButton(xbox, 1).whileTrue(new ElevatorDownCommand(elevatorSubsystem, -0.5));
   //new JoystickButton(xbox, 4).whileTrue(new ElevatorUpCommand(elevatorSubsystem, 0.5));

   new JoystickButton(xbox, 1).whileTrue(new ArmDownCommand(armSubsystem, -0.5));
   new JoystickButton(xbox, 4).whileTrue(new ArmUpCommand(armSubsystem, 0.5));

   new JoystickButton(xbox, 2).onTrue(new ElevatorTopCommand(elevatorSubsystem));
   new JoystickButton(xbox, 3).onTrue(new ElevatorMiddleCommand(elevatorSubsystem));
   new JoystickButton(xbox, 5).onTrue(new ElevatorHybridCommand(elevatorSubsystem));

   //new JoystickButton(xbox, 2).onTrue(new ArmCommand(armSubsystem, armSubsystem.speedLimit(1)));
 
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
