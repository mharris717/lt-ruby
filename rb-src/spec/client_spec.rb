require 'rspec'
load File.dirname(__FILE__) + "/../lt_client.rb"


describe "basic" do
  it 'smoke' do
    2.should == 2
  end

  it 'create a client' do
    LtClient.new(nil).should be
  end
end

describe "eval" do
  let(:client) do
    LtClient.new(nil).tap do |res|
      res.eval_queue = ""
    end
  end

  it 'sends response' do
    args = {"result" => "42", "meta" => {"start" => 1, "end" => 1}}
    client.should_receive(:send_response).with(1,"editor.eval.ruby.result",args)
    client.eval_ruby 1, 'code' => "a = 42"
  end
end
