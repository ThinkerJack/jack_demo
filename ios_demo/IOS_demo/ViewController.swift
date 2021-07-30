//
//  ViewController.swift
//  IOS_demo
//
//  Created by orangelab on 2021/7/2.
//

import UIKit

class LoginViewController: UIViewController {
    var lable:UILabel?
    override func viewDidLoad() {
        super.viewDidLoad()
        lable?.frame = CGRect(x: 50, y: 100, width: 120, height: 100)
    }
    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        return true
    }
    @IBAction func touch(_ sender: Any) {
        print(#function)
        let viewController = TestViewController(data: "第一个页面")
        viewController.closure = {(data:String)in self.lable?.text=data}
        print(lable?.text)

        self.present(viewController, animated: true, completion:nil)
    }
    
}

class RegisterViewController: UIViewController {

    @IBOutlet weak var password: UITextField!
    @IBOutlet weak var account: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
    }
   
    @IBAction func registerButton(_ sender: Any) {
        if password.text == ""{
            print("没密码")
            return
        }
        if account.text == ""{
            print("没账号")
            return
        }
        print(#function)
        navigationController?.popViewController(animated: true)
    }
    
}
class ButtonViewController: UIViewController,UITextFieldDelegate{
    @objc func touch(sender: UIButton){
        print(#function);
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        let buttonOne = UIButton(type: UIButton.ButtonType.system)
        buttonOne.frame = CGRect(x:50,y:200,width: 100,height: 30)
        buttonOne.backgroundColor = UIColor.purple
        buttonOne.setTitle("标题",for: UIControl.State.normal)
        buttonOne.setTitleColor(UIColor.white, for: UIControl.State.normal)
        buttonOne.addTarget(self, action: #selector(touch), for: UIControl.Event.touchUpInside)
        self.view.addSubview(buttonOne)
        let textField = UITextField(frame: CGRect(x:50,y:300,width: 100,height: 30))
        textField.borderStyle = UITextField.BorderStyle.line
        textField.placeholder = "请输入"
        textField.delegate = self
        self.view.addSubview(textField)
        
    }
  
    func textFieldDidBeginEditing(_ textField: UITextField) {
        print("111")
    }
}
