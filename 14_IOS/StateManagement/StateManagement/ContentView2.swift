//
//  ContentView2.swift
//  StateManagement
//
//  Created by Admin on 8/19/25.
//

import SwiftUI

// @Binding 사용법
struct ContentView2: View {
    @State private var isOn = false
    @State private var input = ""
    
    var body: some View {
        ToggleView(isOn: $isOn)
        Text(isOn ? "ON" : "OFF")
        
        TextField("텍스트를 입력해주세요.", text: $input)
        Text(input)
    }
}

struct ToggleView: View {
    @Binding var isOn: Bool // 부모 view와 바인딩
    
    var body: some View {
        Toggle("스위치", isOn: $isOn)
            .frame(width:150)
    }
}

#Preview {
    ContentView2()
}
