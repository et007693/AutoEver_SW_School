//
//  CouterView5.swift
//  StateManagement
//
//  Created by Admin on 8/19/25.
//

import SwiftUI

class CounterModel2: ObservableObject {
    @Published var count = 0
}

struct ChildView: View {
    // ObservedObject는 바인딩과 비슷함
    // @Binding은 단순한 값을 받을 때 사용
    @ObservedObject var counterModel: CounterModel2
    
    var body: some View {
        Button("증가") {
            counterModel.count += 1
        }
    }
}

struct ChildView2: View {
    @ObservedObject var counterModel: CounterModel2
    
    var body: some View {
        Button("증가") {
            counterModel.count += 1
        }
    }
}

struct ContentView5: View {
    @StateObject var counterModel = CounterModel2()
    
    var body: some View {
        VStack {
            Text("카운트: \(counterModel.count)")
            ChildView(counterModel: counterModel)
                .background(Color.red)
            ChildView2(counterModel: counterModel)
                .background(Color.yellow)
        }
    }
}

#Preview {
    ContentView5()
}
