// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.DriveConstants;
import java.util.function.BooleanSupplier;

// Class to get button inputs from Joystick Library/Controllers
public class ControllerUtils {
  private Joystick driver = new Joystick(DriveConstants.kDrveControllerPort);
  private Joystick operator = new Joystick(DriveConstants.kDrveControllerPort);

  public Trigger supplier(int buttonID, DriveConstants.joysticks joystick) {
    if (joystick == DriveConstants.joysticks.DRIVER) {
      BooleanSupplier bsup = () -> driver.getRawButton(buttonID);
      Trigger mybutton = new Trigger(bsup);
      return mybutton;
    } else {
      BooleanSupplier bsup = () -> operator.getRawButton(buttonID);
      Trigger mybutton = new Trigger(bsup);
      return mybutton;
    }
  }

  public boolean getPOVbutton(int degree, DriveConstants.joysticks joystick) {
    double point;
    if (joystick == DriveConstants.joysticks.DRIVER) {
      point = driver.getPOV();
      if (point == degree) {
        return true;
      } else {
        return false;
      }
    } else {
      point = operator.getPOV();
      if (point == degree) {
        return true;
      } else {
        return false;
      }
    }
  }

  public Trigger POVsupplier(int angle, DriveConstants.joysticks joystick) {
    if (joystick == DriveConstants.joysticks.DRIVER) {
      BooleanSupplier bsup = () -> getPOVbutton(angle, joystick);
      Trigger mybutton = new Trigger(bsup);
      return mybutton;
    } else {
      BooleanSupplier bsup = () -> getPOVbutton(angle, joystick);
      Trigger mybutton = new Trigger(bsup);
      return mybutton;
    }
  }
}
