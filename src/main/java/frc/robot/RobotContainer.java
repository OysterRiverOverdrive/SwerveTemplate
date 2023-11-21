// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.TeleopCmd;
import frc.robot.subsystems.DrivetrainSubsystem;

public class RobotContainer {
  // Subsystems
  private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();

  // Commands
  private final TeleopCmd teleopCmd = new TeleopCmd(drivetrain);

  public RobotContainer() {
    // Configure the trigger bindings
    drivetrain.setDefaultCommand(teleopCmd);
    configureBindings();
  }

  private void configureBindings() {
    // Configure buttons
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // Return NOTHING
    return null;
  }
}
