//
//  TestViewController.swift
//  IOS_demo
//
//  Created by orangelab on 2021/7/13.
//

import UIKit

class TestViewController: UIViewController {
    var data:String?
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
     init(data:String) {
        self.data = data;
        super.init(nibName: nil, bundle: nil)
    }
    var closure:((String)->Void)?

    override func viewDidLoad() {
        print(data)
        super.viewDidLoad()
        let buttonOne = UIButton(type: UIButton.ButtonType.system)
        buttonOne.frame = CGRect(x:50,y:200,width: 100,height: 30)
        buttonOne.backgroundColor = UIColor.purple
        buttonOne.setTitle("标题",for: UIControl.State.normal)
        buttonOne.setTitleColor(UIColor.white, for: UIControl.State.normal)
        buttonOne.addTarget(self, action: #selector(ret), for: UIControl.Event.touchUpInside)

        self.view.addSubview(buttonOne)
        // Do any additional setup after loading the view.
    }
    @objc func ret(sender: UIButton)
    {
        self.closure!("第二个洁面")
        self.dismiss(animated: true, completion: nil)
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
