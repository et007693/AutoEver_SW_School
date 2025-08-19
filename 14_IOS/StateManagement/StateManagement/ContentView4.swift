//
//  ContentView4.swift
//  StateManagement
//
//  Created by Admin on 8/19/25.
//

import SwiftUI

// CounterModel은 ObservableObject 프로토콜을 준수함
class CounterModel: ObservableObject {
    @Published var count: Int = 0
}

struct ContentView4: View {
    @StateObject var counter = CounterModel()
    
    var body: some View {
        VStack {
            View1()
                .background(Color.red)
        }
    }
}

struct View1: View {
    @StateObject var counter = CounterModel()

    var body: some View {
        VStack {
            Text("카운트: \(counter.count)")
            Button("증가") {
                counter.count+=1;
            }
        }
    }
}

#Preview {
    ContentView4()
}
