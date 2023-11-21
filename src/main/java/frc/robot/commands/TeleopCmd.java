// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TeleopCmd extends CommandBase {
  /** Creates a new TeleopCmd. */
  private final DrivetrainSubsystem driveSub;

  private final Joystick controller = new Joystick(DriveConstants.kDrveControllerPort);

  public TeleopCmd(DrivetrainSubsystem drives) {
    driveSub = drives;
    addRequirements(driveSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double ContX = controller.getRawAxis(DriveConstants.kDriveX);
    double ContY = controller.getRawAxis(DriveConstants.kDriveY);
    double ContRotate = controller.getRawAxis(DriveConstants.kDriveRotate);
    driveSub.drive(ContX, ContY, ContRotate, false, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
