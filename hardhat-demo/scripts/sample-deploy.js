const hre = require("hardhat");
const {
    ConfluxSDK, // The js-conflux-sdk SDK
    conflux, // The Conflux instance
} = hre;

async function main() {
    // 获取当前用户的账号
    const accounts = await conflux.getSigners();
    const account = accounts[0].address;

    // 获取要部署的合约
    const test = await conflux.getContractFactory("Test");

    // 部署（链接中的json文件不存在）
    const deployReceipt = await test.constructor(
        "TestNFT",
        "TNFT",
        "https://conflux-edu.oss-cn-beijing.aliyuncs.com/metadata/test.json")
        .sendTransaction({
            from: account,
        }).executed();

    console.log("Contract deployed to:", deployReceipt.contractCreated);
}

main()
    .then(() => process.exit(0))
    .catch((error) => {
        console.error(error);
        process.exit(1);
    });
